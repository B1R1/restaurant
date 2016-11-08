package model.controllers;

import model.Employees;
import model.EmployeeDao;
import model.Ingredient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void add(String surname, String name) {
        employeeDao.add(surname, name);
    }

    @Transactional
    public void delete(Employees employee){
        employeeDao.delete(employee);
    }

    @Transactional
    public void deleteById(int id){
        employeeDao.deleteById(id);
    }

    @Transactional
    public List<Employees> getByName(String name) {
        return employeeDao.getByName(name);
    }

    @Transactional
    public Employees getByNameReturnEmployee(String name) {
        List<Employees> list = employeeDao.getByName(name);
        return list.get(0);
    }

    @Transactional
    public Employees getById(int id) {
        return employeeDao.getById(id);
    }

    @Transactional
    public List<Employees> getAll() {
        return employeeDao.getAll();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
