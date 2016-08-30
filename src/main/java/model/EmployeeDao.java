package model;

import java.util.List;

public interface EmployeeDao {

    void addNewEmployee(int id, String surname, String name);

    int deleteEmployeeById(int id);

    List<Employee> getEmployeeByName(String name);

    List<Employee> getAllEmployee();
}
