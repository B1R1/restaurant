package model.hibernate;

import model.Ingredient;
import model.IngredientDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HIngredientDao implements IngredientDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addIngredient(String name) {

    }

    @Override
    @Transactional
    public void deleteByName(String name) {

    }

    @Override
    @Transactional
    public Ingredient getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from Ingredient i where i.name like :name");
        query.setParameter("name", name);
        return (Ingredient) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Ingredient> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from Ingredient i");
        return query.getResultList();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
