package model.hibernate;

import model.Dishes;
import model.DishDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Dishes dish) {
        sessionFactory.getCurrentSession().save(dish);
    }


    @Override
    @Transactional
    public void add(String dishName, String category) {

    }

    @Override
    @Transactional
    public int deleteByName(String name) {
        return 0;
    }

    @Override
    @Transactional
    public Dishes findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dishes d where d.name like :name");
        query.setParameter("name", name);
        return (Dishes) query.getResultList();
    }

    @Override
    @Transactional
    public List<Dishes> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dishes d").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
