package model.controllers;

import model.Employees;
import model.EmployeeDao;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee() {

        Set<Employees> allEmployee = new HashSet<>(employeeDao.getAllEmployee());

        Employees employee = new Employees();
        employee.setName("Burko-55");
        employee.setSurname("Hibernate");
        employee.setPosition("WAITER");
        employee.setPhoneNumber(new BigDecimal(String.valueOf(5555555)));
        employee.setSalary(25000.0F);

        if(!allEmployee.contains(employee)) {
            employeeDao.save(employee);
        }
        System.out.println("ADDED");
    }

    @Transactional
    public List<Employees> getByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }

    @Transactional
    public List<Employees> getAll() {
        return employeeDao.getAllEmployee();
    }

    @Transactional
    public void printEmployee(String name) {
       getByName(name).forEach(System.out::println);
    }

    @Transactional
    public void printAllEmployee() {
        getAll().forEach(System.out::println);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
