package model.controllers;

import model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class OrderController {

    private OrderDao orderDao;
    private EmployeeDao employeeDao;
    private DishDao dishDao;

    @Transactional
    public void createOrder(int waiterId, List<String> dishes, int tableNumber){
        Orders orders = new Orders();
//        orders.setWaiterId(employeeDao.deleteById(waiterId));
        orders.setReadyDishes(createDishes(dishes));
        orders.setTableNumber(tableNumber);

        orderDao.save(orders);
    }

    @Transactional
    public List<Orders> getAll(){
        return orderDao.getAllOrders();
    }

    @Transactional
    public List<Dishes> createDishes(List<String> dishes) {
        List<Dishes> result = new ArrayList<>();
        for(String dishName : dishes){
            result.add(dishDao.getByName(dishName));
        }
        return result;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
