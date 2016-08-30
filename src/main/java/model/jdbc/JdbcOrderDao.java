package model.jdbc;

import model.Employee;
import model.MenuDao;
import model.Order;
import model.OrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JdbcOrderDao implements OrderDao {

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcOrderDao.class);

    @Override
    public void addOrder() {

        int maxOrderNumber = 0;
        List<Order> orders = new ArrayList<>();
        orders.addAll(getAllOpenOrders());
        orders.addAll(getAllClosedOrders());
        for (Order item : orders) {
            if (item.getOrderId() > maxOrderNumber) {
                maxOrderNumber = item.getOrderId();
            }
        }
        int orderNumber = maxOrderNumber+1;

        int numberOfWaiters = 0;
        JdbcEmployeeDao employeeDao = new JdbcEmployeeDao();
        List<Employee> employees = employeeDao.getAllEmployee();
        for (Employee itemRsult : employees){
            if (itemRsult.getPosition().equals("waiter")){
                numberOfWaiters++;
            }
        }
        int id = new Random().nextInt(numberOfWaiters);

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO orders (order_number, waiter_id) VALUES (?, ?)");
            statement.setInt(1, orderNumber);
            statement.setInt(2, id);
            LOGGER.info("Successfully add new Order with orderNumber=" + orderNumber);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method add(Dish dish) ", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addDish(int  menuId, String dishName) {
       // add check method parameters
        try (
                Connection connection = dataSource.getConnection()) {
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO dishes_to_menu(menu_id, dish_name) VALUES (?, ?)");
            statement.setInt(1, menuId);
            statement.setString(2, dishName);
            LOGGER.info("Successfully add new Dish with menuId=" + menuId + ", dishName=" + dishName);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method addDish(int  menuId, String dishName) ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteDish(String dishName) {
        int affectedRows = 0;
        try (
                Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM dishes_to_menu WHERE dish_name = ?");
            statement.setString(1, dishName);
            affectedRows++;
            LOGGER.info("Successfully add new Dish with dishName=" + dishName);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method adeleteDish(String dishName) ", e);
            throw new RuntimeException(e);
        }
        return affectedRows;
    }

    @Override
    public int deleteOrder(int id) {
        int affectedRows = 0;
        try (
                Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM orders WHERE orders_number = ? AND isOpen = ?");
            statement.setInt(1, id);
            statement.setBoolean(2, true);
            affectedRows++;
            LOGGER.info("Successfully delete  Order with id=" + id);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method deleteOrder(int id) ", e);
            throw new RuntimeException(e);
        }
        return affectedRows;
    }

    @Override
    public int closeOrder(int id) {
        int affectedRows = 0;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE orders SET isOpen = ? WHERE order_number = ?")) {
            statement.setBoolean(1, false);
            statement.setInt(2, id);
            affectedRows++;
            LOGGER.info("Successfully close Order with id=" + id);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method closeOrder(int id) ", e);
            throw new RuntimeException(e);
        }
        return affectedRows;
    }

    @Override
    public List<Order> getAllOpenOrders() {
        List<Order> result = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE isOpen = ?")) {
            statement.setBoolean(1, true);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(createOrder(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getAllOpenOrders() ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Order> getAllClosedOrders() {
        List<Order> result = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE isOpen = ?")) {
            statement.setBoolean(1, false);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(createOrder(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getAllClosedOrders() ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    private Order createOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setOrderId(resultSet.getInt("orderId"));
        order.setWaiterId(resultSet.getInt("waiter_id"));
        order.setDishes(getDishesInMenu());
        order.setTableNumber(resultSet.getInt("table_number"));
        order.setDate(resultSet.getString("date"));
        order.setOpen(resultSet.getBoolean("isOpen"));
        return order;
    }

    private List<String> getDishesInMenu() {
        List<String> dishesInMenu = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dishes_to_menu");
            while (resultSet.next()) {
                dishesInMenu.add(resultSet.getString("dish_name"));
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getDishesInMenu() ", e);
            throw new RuntimeException(e);
        }
        return dishesInMenu;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
