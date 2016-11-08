package model.hibernate;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;


import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;
    private DishDao dishDao;
    private DishToMenuDao dishToMenuDao;

    @Override
    @Transactional
    public void add(Dishes dish) {
        List<Dishes> list = dishDao.getAll();
        List<String> stringList = new ArrayList<>();
        for (Dishes item : list){
            stringList.add(item.getDishName());
        }

        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if(!stringList.contains(dish.getDishName())){
            session.save(dish);
            session.getTransaction().commit();
            System.out.println("Successfully saved new Dish to DB");
        } else {
            session.delete(dishDao.getByName(dish.getDishName()));
            session.save(dish);
            session.getTransaction().commit();
            System.out.println("Successfully upgrade Dish to DB");
        }
    }

    @Override
    @Transactional
    public void add(String name, String category) {
        Set<Dishes> allDishes = new HashSet<>(dishDao.getAll());

        Dishes dish = new Dishes();
        dish.setDishName(name);
        dish.setCategory(category);

        if(!allDishes.contains(dish)) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(dish);
            session.getTransaction().commit();
            System.out.println("Saved new Dish to DB");
        }
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(dishDao.getByName(name));
            session.getTransaction().commit();
            System.out.println("Dish deleted from DB");
        }catch (RuntimeException e){
            System.out.println("No Dish in DB to deleteByName");
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {

            session.delete(dishToMenuDao.getById(id)); // не то ID
            session.delete(dishDao.getById(id));
            session.getTransaction().commit();
            System.out.println("Dish deleted from DB");
        }catch (RuntimeException e){
            System.out.println("No Dish in DB to deleteById");
        }
    }

    @Override
    @Transactional
    public Dishes getById(int id) {
        Session session = null;
        Dishes dish = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            dish = session.load(Dishes.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception 'getById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return dish;
    }

    @Override
    @Transactional
    public Dishes getByName(String name) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Query query = sessionFactory.openSession().createQuery("select d from Dishes d where d.dishName like :name");
        query.setParameter("name", name);
        return (Dishes) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Dishes> getAll() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.openSession().createQuery("select d from Dishes d").list();    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setDishToMenuDao(DishToMenuDao dishToMenuDao) {
        this.dishToMenuDao = dishToMenuDao;
    }
}
