package model;

import java.util.List;

public interface EmployeeDao {

    void add(String surname, String name);
    void delete (Employees employee);
    int deleteById(int id);
    List<Employees> getByName(String name);
    Employees getById(int id);
    List <Employees> getAll();
}
