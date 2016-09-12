package model;

import java.util.List;

public interface EmployeeDao {

    void save(Employees employee);
    void addNewEmployee(int id, String surname, String name);
    void delete (Employees employee);
    int deleteEmployeeById(int id);
    List<Employees> getEmployeeByName(String name);
    Employees getEmployeeById(int id);
    List getAllEmployee();
}
