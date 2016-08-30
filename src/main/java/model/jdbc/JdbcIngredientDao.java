package model.jdbc;

import model.Dish;
import model.Ingredient;
import model.IngredientDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcIngredientDao implements IngredientDao {

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcIngredientDao.class);

    @Override
    public void addIngredient(String name) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public Ingredient getByName(String name){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM ingredients WHERE NAME = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createIngredient(resultSet);
            } else
                throw new RuntimeException("Cannot find Ingredient with name: " + name);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getByName(String name) ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ingredient> getAll() {
        List<Ingredient> ingredients = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ingredients");
            while (resultSet.next()){
                ingredients.add(createIngredient(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getAll()", e);
            throw new RuntimeException(e);
        }
        return ingredients;
    }

    private Ingredient createIngredient(ResultSet resultSet) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(resultSet.getString("name"));
        return ingredient;
    }
}