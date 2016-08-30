package model.jdbc;

import model.Order;
import model.ReadyDish;
import model.ReadyDishDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcReadyDishDao implements ReadyDishDao {

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcReadyDishDao.class);

    @Override
    public int add(int dishNumber, String dishName, int chefId, int orderNumber) {
        int affectedRows = 0;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO ready_dishes (dish_number, dish_name, chef_id, order_number) VALUES (?,?,?,?)");
            statement.setInt(1, dishNumber);
            statement.setString(2, dishName);
            statement.setInt(3, chefId);
            statement.setInt(4, orderNumber);
            affectedRows++;
            LOGGER.info("Successfully add new ReadyDish with dishNumber=" + dishNumber + ", dishName=" + dishName +
                    ", chefId=" + chefId + ", orderNumber=" + orderNumber);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method " +
                    "add(int dishNumber, String dishName, int chefId, int orderNumber) ", e);
            throw new RuntimeException(e);
        }
        return affectedRows;
    }

    @Override
    public List<ReadyDish> getAll() {
        List<ReadyDish> result = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ready_dishes");
            while (resultSet.next()) {
                result.add(createReadyDish(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getAllClosedOrders() ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    private ReadyDish createReadyDish(ResultSet resultSet) throws SQLException {
        ReadyDish dish = new ReadyDish();
        dish.setDishId(resultSet.getInt("dish_number"));
        dish.setDishName(resultSet.getString("dish_name"));
        dish.setCookId(resultSet.getInt("chef_id"));
        dish.setOrderNumber(resultSet.getInt("order_number"));
        dish.setDate(resultSet.getString("date"));
        return dish;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
