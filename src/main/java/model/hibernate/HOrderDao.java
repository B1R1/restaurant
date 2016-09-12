package model.hibernate;

import model.Orders;
import model.OrderDao;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Orders order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    @Transactional
    public void addOrder() {

    }

    @Override
    @Transactional
    public void addDish(int menuId, String dishName) {

    }

    @Override
    @Transactional
    public int deleteDish(String dishName) {
        return 0;
    }

    @Override
    @Transactional
    public int deleteOrder(int id) {
        return 0;
    }

    @Override
    @Transactional
    public int closeOrder(int id) {
        return 0;
    }

    @Override
    @Transactional
    public List<Orders> getAllOpenOrders() {
        return null;
    }

    @Override
    @Transactional
    public List<Orders> getAllClosedOrders() {
        return null;
    }

    @Override
    public List<Orders> getAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
