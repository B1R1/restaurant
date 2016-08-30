package model.jdbc;

import model.Dish;
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
    public void add(String dishName, String category) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO dish (dishName, category) VALUES (?, ?)");
            statement.setString(1, dishName);
            statement.setString(2, category);
            LOGGER.info("Successfully add new Dish with dishName=" + dishName + ", category=" + category);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method add(Dish dish) ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteByName(String name) {
        int affectedRows = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM dish WHERE dishName= ?")) {
            statement.setString(1, name);
            affectedRows = statement.executeUpdate();
            LOGGER.info("Successfully delete Employee by name=" + name);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method  deleteByName(String name)", e);
            throw new RuntimeException (e);
        }
        return affectedRows;
    }

    @Override
    public Dish findByName(String name) {
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =connection.prepareStatement("SELECT * FROM dish WHERE NAME = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               return createDish(resultSet);
            } else
                throw new RuntimeException("Cannot find Dish with name: " + name);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getByName(String name)", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Dish> getAll() {
        List<Dish> result = new ArrayList<>();
        try (
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM dish");
                while (resultSet.next()){
                    result.add(createDish(resultSet));
                }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getAll()", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public Dish createDish(ResultSet resultSet) throws SQLException {
        Dish dish = new Dish();
        dish.setId(resultSet.getInt("Id"));
        dish.setDishName(resultSet.getString("DishName"));
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
                ingredient.setIngredientName(resultSet.getString("ingredientName"));
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
