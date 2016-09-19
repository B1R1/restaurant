package model.hibernate;

import model.Dishes;
import model.DishDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;
    private DishDao dishDao;

    @Override
    @Transactional
    public void add(Dishes dish) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(dish);
        session.getTransaction().commit();
        System.out.println("Successfully saved new Dish to DB");
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
    public int deleteByName(String name) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(dishDao.getByName(name));
            session.getTransaction().commit();
            System.out.println("Dish deleted from DB");
        }catch (RuntimeException e){
            System.out.println("No Dish in DB to delete");
        }
        return 1;
    }

    @Override
    @Transactional
    public Dishes getByName(String name) {
        List<Dishes> dishes = new ArrayList<>();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Query query = sessionFactory.openSession().createQuery("select d from Dishes d where d.dishName like :name");
        query.setParameter("name", name);
        dishes = query.getResultList();

        if (dishes == null || dishes.size() == 0) {
            throw new RuntimeException("Cannot find Employee with name: " + name);
        }

        return dishes.get(1);
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
}
