package model.hibernate;

import model.Employees;
import model.Ingredient;
import model.IngredientDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HIngredientDao implements IngredientDao {

    private SessionFactory sessionFactory;
    private IngredientDao ingredientDao;

    @Override
    @Transactional
    public void add(Ingredient ingredient) {
        List<Ingredient> list = ingredientDao.getAll();
        List<String> stringList = new ArrayList<>();
        for (Ingredient item : list){
            stringList.add(item.getName());
        }

        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if(!stringList.contains(ingredient.getName())){
            session.save(ingredient);
            session.getTransaction().commit();
            System.out.println("Successfully add new Ingredient to DB");
        } else {
            session.delete(ingredientDao.getByName(ingredient.getName()));
            session.save(ingredient);
            session.getTransaction().commit();
            System.out.println("Successfully upgrade new Ingredient to DB");
        }

//        Set<Ingredient> allIngredients = new HashSet<>(ingredientDao.getAll());
//        if(!allIngredients.contains(ingredient)){
//            ingredientDao.add(ingredient);
//        sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(ingredient);
//        session.getTransaction().commit();
//        System.out.println("Successfully add new Ingredient to DB");
//        }
    }

    @Override
    @Transactional
    public void addByName(String name) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Ingredient(name));
        session.getTransaction().commit();
        System.out.println("Successfully saved new Ingredient to DB");
    }

    @Override
    public void update(Ingredient ingredient) {

    }

    @Override
    @Transactional
    public void delete(Ingredient ingredient) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(ingredient);
            session.getTransaction().commit();
            System.out.println("Ingredient deleted from DB");
        }catch (RuntimeException e){
            System.out.println("No Ingredient in DB to delete");
        }

    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(ingredientDao.getByName(name));
            session.getTransaction().commit();
            System.out.println("Ingredient deleted from DB");
        }catch (RuntimeException e){
            System.out.println("No Ingredient in DB to deleteByName");
        }

    }

    @Override
    @Transactional
    public Ingredient getByName(String name) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Query query = sessionFactory.openSession().createQuery("select i from Ingredient i where i.name like :name");
        query.setParameter("name", name);
        return (Ingredient) query.uniqueResult();

    }

    @Override
    @Transactional
    public Ingredient getById(int id) {
        Session session = null;
        Ingredient ingredient = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            ingredient = session.load(Ingredient.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception 'getById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ingredient;
    }

    @Override
    @Transactional
    public List<Ingredient> getRunningOut() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.openSession().createQuery("select i from Ingredient i where i.quantity <= 20").list();
    }

    @Override
    @Transactional
    public List<Ingredient> getAll() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.openSession().createQuery("select i from Ingredient i").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
