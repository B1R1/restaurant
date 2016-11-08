package model.jdbc;

import model.Dishes;
import model.DishDao;
import model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDishDao implements DishDao {

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDishDao.class);

    @Override
    public void add(Dishes dish) {

    }

    @Override
    public void add(String dishName, String category) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO dish (dishName, category) VALUES (?, ?)");
            statement.setString(1, dishName);
            statement.setString(2, category);
            LOGGER.info("Successfully addMenu new Dishes with dishName=" + dishName + ", category=" + category);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method addMenu(Dishes dish) ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByName(String name) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM dish WHERE dishName= ?")) {
            statement.setString(1, name);
            statement.executeUpdate();
            LOGGER.info("Successfully deleteByName Employees by name=" + name);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method  deleteMenu(String name)", e);
            throw new RuntimeException (e);
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Dishes getById(int id) {
        return null;
    }

    @Override
    public Dishes getByName(String name) {
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =connection.prepareStatement("SELECT * FROM dish WHERE NAME = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               return createDish(resultSet);
            } else
                throw new RuntimeException("Cannot find Dishes with name: " + name);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getByName(String name)", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Dishes> getAll() {
        List<Dishes> result = new ArrayList<>();
        try (
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM dishes");
                while (resultSet.next()){
                    result.add(createDish(resultSet));
                }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getAll()", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public Dishes createDish(ResultSet resultSet) throws SQLException {
        Dishes dish = new Dishes();
        dish.setId(resultSet.getInt("Id"));
        dish.setDishName(resultSet.getString("Name"));
        dish.setCategory(resultSet.getString("Category"));
        dish.setIngredients(getIngredients());
        dish.setPrice(resultSet.getDouble("price"));
        return dish;
    }

    private List<Ingredient> getIngredients(){
        List<Ingredient> result = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ingredients");
            while (resultSet.next()){
                Ingredient ingredient = new Ingredient();
                ingredient.setName(resultSet.getString("name"));
                result.add(ingredient);
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getAll()", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
