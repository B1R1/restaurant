package model.jdbc;

import model.Ingredient;
import model.StorageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JdbcStorageDao implements StorageDao {

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcStorageDao.class);

    @Override
    public int addIngredient(String name, int amount) {
        int affectedRows = 0;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO storage (name, amount) VALUES (?,?)");
            statement.setString(1, name);
            statement.setInt(2, amount);
            affectedRows++;
            LOGGER.info("Successfully addMenu new Ingredient with ingredient=" + name + ", amount=" + amount);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method addIngredient(String name, int amount)", e);
            throw new RuntimeException(e);
        }
        return affectedRows;

    }

    @Override
    public int deleteIngredient(String name) {
        int affectedRows = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM storage WHERE name = ?")) {
            statement.setString(1, name);
            affectedRows++;
            LOGGER.info("Successfully deleteByName Ingredient by name=" + name);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method deleteIngredient(String name)", e);
            throw new RuntimeException (e);
        }
        return affectedRows;
    }

    @Override
    public int changeAmount(String name, int newAmount) {
        int affectedRow = 0;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement =connection.prepareStatement("UPDATE storage SET amount = ? WHERE NAME = ?")) {
            statement.setInt(1, newAmount);
            statement.setString(2, name);
            affectedRow++;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getByName(String name)", e);
            throw new RuntimeException(e);
        }
        return affectedRow;
    }

    @Override
    public Ingredient getByName(String name) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement =connection.prepareStatement("SELECT * FROM storage WHERE NAME = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setName(resultSet.getString("ingredients"));
                return ingredient;
            } else
                throw new RuntimeException("Cannot find Ingredient with name: " + name);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getByName(String name)", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<Ingredient, Integer> getAll() {
        Map<Ingredient, Integer> storage = new HashMap<>();
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM storage");
            while (resultSet.next()){
                Ingredient ingredient = new Ingredient();
                ingredient.setName(resultSet.getString("ingredients"));
                int amount = resultSet.getInt("amount");
                storage.put(ingredient, amount);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getAll()", e);
            throw new RuntimeException(e);
        }
        return storage;

    }

    @Override
    public Map<Ingredient, Integer> getAllFinishingIngredients(int amount) {
        Map<Ingredient, Integer> storage = new HashMap<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM storage WHERE amount < ?")) {
            statement.setInt(1, amount);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setName(resultSet.getString("ingredients"));
                int amountResult = resultSet.getInt("amount");
                storage.put(ingredient, amountResult);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getAllFinishingIngredients(int amount)", e);
            throw new RuntimeException(e);
        }
        return storage;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
