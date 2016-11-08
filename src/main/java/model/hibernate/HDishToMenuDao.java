package model.hibernate;

import model.DishToMenuDao;
import model.Dishes;
import model.DishesToMenu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

import javax.swing.*;

public class HDishToMenuDao implements DishToMenuDao {

    private SessionFactory sessionFactory;
    private DishToMenuDao dishToMenuDao;

    @Override
    @Transactional
    public void delete (DishesToMenu dishesToMenu){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(dishesToMenu);
            session.getTransaction().commit();
            System.out.println("DishesToMenu deleted from DB");
        }catch (RuntimeException e){
            System.out.println("No DishesToMenu in DB to delete");
        }

    }

    @Override
    @Transactional
    public void deleteDish(int menuId, int dishId) {
//        sessionFactory = new Configuration().configure().buildSessionFactory();
//        Query query = sessionFactory.openSession().createQuery("delete from DishesToMenu d where" +
//                " menuId= :menuId AND dishId= :dishId");
//        query.setParameter("menuId", menuId);
//        query.setParameter("dishId", dishId);


        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        DishesToMenu dishToMenu = dishToMenuDao.getById(dishId);
        try {
            session.delete(dishToMenu);
            session.getTransaction().commit();
            System.out.println("Dish deleted from DB");
        }catch (RuntimeException e){
            System.out.println("No Dish in DB to deleteByName");
        }

    }

    @Override
    @Transactional
    public DishesToMenu getById(int id) {
//        sessionFactory = new Configuration().configure().buildSessionFactory();
//        Query query = sessionFactory.openSession().createQuery("select d from DishesToMenu d where d.id like :id");
//        query.setParameter("id", id);
//        return (DishesToMenu) query.uniqueResult();

        Session session = null;
        DishesToMenu dish = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            dish = session.load(DishesToMenu.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception 'getById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return dish;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setDishToMenuDao(DishToMenuDao dishToMenuDao) {
        this.dishToMenuDao = dishToMenuDao;
    }
}
