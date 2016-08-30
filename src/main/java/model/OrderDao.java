package model;

import java.util.List;

public interface OrderDao {

    void addOrder();
    void addDish(int menuId, String dishName);
    int deleteDish(String dishName);
    int deleteOrder(int id);
    int closeOrder(int id);
    List<Order> getAllOpenOrders();
    List<Order> getAllClosedOrders();
}