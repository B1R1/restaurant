package model.jdbc;

import model.Menu;
import model.MenuDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMenuDao implements MenuDao {

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcMenuDao.class);

    @Override
    public void add(String name) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO menu (name) VALUES (?)");
            statement.setString(1, name);
            LOGGER.info("Successfully add new Menu with name=" + name);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method add(String name) ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteByName(String name) {
        int affectedRows = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM menu WHERE name= ?")) {
            statement.setString(1, name);
            affectedRows = statement.executeUpdate();
            LOGGER.info("Successfully delete Menu by name=" + name);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method  deleteByName(String name)", e);
            throw new RuntimeException (e);
        }
        return affectedRows;
    }

    @Override
    public void addDish(String menuName, String dishName) {
        JdbcDishDao dish = new JdbcDishDao();
        int id = findByName(menuName).getId();
        if(id<=0) {
            throw new RuntimeException("Cannot find Menu with name: " + menuName);
        }

        String name  = dish.findByName(dishName).getDishName();
        if(name.isEmpty()){
            throw new RuntimeException("Cannot find Dish with name: " + dishName);
        }

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement =connection.prepareStatement("INSERT INTO dishes_to_menu VALUES (?, ?)")) {
            statement.setInt(1, id);
            statement.setString(2, name);
            LOGGER.info("Successfully add new Dish to mne with menuName=" + menuName + ", dishName=" + dishName);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method addDish(String menuName, String dishName) ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteDish(String menuName, String dishName) {
        JdbcDishDao dishResult = new JdbcDishDao();
        int affectedRows = 0;

        String name  = dishResult.findByName(dishName).getDishName();
        if(name.isEmpty()){
            throw new RuntimeException("Cannot find Dish with name: " + dishName);
        }

        int id = findByName(menuName).getId();
        if(id<=0) {
            throw new RuntimeException("Cannot find Menu with name: " + menuName);
        }

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement =connection.prepareStatement("DELETE FROM dishes_to_menu WHERE dish_name= ? AND menu_id = ? ")) {
            statement.setString(1, name);
            statement.setInt(1, id);
            LOGGER.info("Successfully delete Dish to mne with menuName=" + menuName + ", dishName=" + dishName);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method deleteDish(String menuName, String dishName) ", e);
            throw new RuntimeException(e);
        }

        return affectedRows;
    }

    @Override
    public Menu findByName(String name) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement =connection.prepareStatement("SELECT * FROM menu WHERE NAME = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createMenu(resultSet);
            } else
                throw new RuntimeException("Cannot find Menu with name: " + name);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getByName(String name)", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> result = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM menu");
            while (resultSet.next()){
                result.add(createMenu(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getAll()", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    private Menu createMenu(ResultSet resultSet) throws SQLException {
        Menu menu = new Menu();
        menu.setId(resultSet.getInt("Id"));
        menu.setName(resultSet.getString("name"));
        return menu;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
