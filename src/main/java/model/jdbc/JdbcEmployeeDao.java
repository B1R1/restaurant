package model.jdbc;

import model.Employees;
import model.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao implements EmployeeDao {

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcEmployeeDao.class);

    @Override
    public void add(String surname, String name) {
//        Employees employees = new Employees();
//        employees.setId(id);
//        employees.setSurname(surname);
//        employees.setSurname(name);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO employee (id, surname, name) VALUES (id, surname, name)")) {
            statement.executeUpdate();
            LOGGER.info("Successfully addMenu new Employees with surname=" + surname + ", name=" + name);
             } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method addMenu(int id, String surname, String name", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Employees employee) {

    }

    @Override
    public int deleteById(int id) {
        int affectedRows = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id= ?")) {
            statement.setInt(1, id);
            affectedRows = statement.executeUpdate();
            LOGGER.info("Successfully deleteByName Employees by ID=" + id);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method deleteById(int id)", e);
            throw new RuntimeException (e);
        }
        // добавить удаление зависимостей: заказ, приготовление блюда
        return affectedRows;
    }

    @Override
    public List<Employees> getByName(String name) {
        List<Employees> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
//             Connection connection = DriverManager.getConnection("dao.jdbc:postgresql://localhost:5433/restaurant", "user" ,"1111");
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM employee WHERE NAME = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(createEmployee(resultSet));
            }
            if (result.size()==0){
                throw new RuntimeException("Cannot find Employees with name: " + name);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB in method getByName(String name)", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Employees getById(int id) {
        return null;
    }

    @Override
//    @Transactional(propagation = Propagation.MANDATORY) - транзакция уже открыта
    public List<Employees> getAll() {
    List<Employees> result = new ArrayList<>();
    try (
            Connection connection = dataSource.getConnection();
         Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");
        while (resultSet.next()) {
            result.add(createEmployee(resultSet));
        }
    } catch (SQLException e) {
        LOGGER.error("Exception occurred while connecting to DB in method getAll()", e);
        throw new RuntimeException(e);
    }
    return result;
}

    private Employees createEmployee(ResultSet resultSet) throws SQLException {
        Employees employee = new Employees();
        employee.setId(resultSet.getInt("ID"));
        employee.setSurname(resultSet.getString("Surname"));
        employee.setName(resultSet.getString("Name"));
        employee.setBirthDate(resultSet.getDate("Birth_Date"));
        employee.setPhoneNumber(resultSet.getBigDecimal("Phone_Number"));
        employee.setPosition(resultSet.getString("Position"));
        employee.setSalary(resultSet.getFloat("Salary"));
        return employee;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
