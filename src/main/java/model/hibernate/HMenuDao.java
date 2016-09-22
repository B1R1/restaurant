package model.hibernate;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HMenuDao implements MenuDao {

    private SessionFactory sessionFactory;
    private MenuDao menuDao;
    private DishDao dishDao;

    @Override
    public void add(Menu menu) {
        Set<Menu> allMenus = new HashSet<>(menuDao.getAll());

        if(!allMenus.contains(menu)) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(menu);
            session.getTransaction().commit();
            System.out.println("Successfully saved Menu to DB");
        }
    }

    @Override
    @Transactional
    public void addMenu(String name) {
        Set<Menu> allMenus = new HashSet<>(menuDao.getAll());

        Menu menu = new Menu();
        menu.setName(name);

        if(!allMenus.contains(menu)) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(menu);
            session.getTransaction().commit();
            System.out.println("Successfully saved new Menu to DB");
        }
    }

    @Override
    @Transactional
    public void deleteMenu(int id) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(menuDao.getMenuById(id));
            session.getTransaction().commit();
            System.out.println("Menu deleted from DB");
        }catch (RuntimeException e){
            System.out.println("No Menu in DB to deleteByName");
        }
    }

    @Override
    @Transactional
    public void addDish(String menuName, String dishName) {
        Set<Dishes> allDishesInMenu = new HashSet<>(menuDao.getMenuByName(menuName).getMenuDishes());

        Dishes dish = new Dishes();
        dish.setDishName(dishName);

        if(!allDishesInMenu.contains(dish.getDishName())) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(dish);
            session.createCriteria(DishesToMenu.class)
                    .add(Restrictions.eq("menu_id", menuName));
            session.getTransaction().commit();
            System.out.println("Successfully saved new Dish to Menu to DB");
        }
    }

    @Override
    @Transactional
    public int deleteDish(String menuName, String dishName) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Dishes dishes = dishDao.getByName(dishName);
            session.delete(dishes);
            session.getTransaction().commit();
            System.out.println("Employee deleted from DB");
        }catch (RuntimeException e){
            System.out.println("No Employee in DB to deleteByName");
        }
        return 1;


    }

    @Override
    @Transactional
    public Menu getMenuByName(String name) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Query query = sessionFactory.openSession().createQuery("select m from Menu m where m.name like :name");
        query.setParameter("name", name);
        return (Menu) query.uniqueResult();
    }

    @Override
    @Transactional
    public Menu getMenuById(int id) {
        Session session = null;
        Menu menu = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            menu = session.load(Menu.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception 'getMenuById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return menu;
    }

    @Override
    @Transactional
    public List<Menu> getAll() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.openSession().createQuery("select m from Menu m").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
