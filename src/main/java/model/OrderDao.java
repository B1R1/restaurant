package model;

import java.util.List;

public interface OrderDao {

    void save(Orders order);
    void addOrder();
    void addDish(int menuId, String dishName);
    int deleteDish(String dishName);
    int deleteOrder(int id);
    int closeOrder(int id);
    List<Orders> getAllOpenOrders();
    List<Orders> getAllClosedOrders();
    List<Orders> getAllOrders();
}