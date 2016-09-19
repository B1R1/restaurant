package model.hibernate;

import model.Employees;
import model.EmployeeDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HEmployeeDao implements EmployeeDao{

    private SessionFactory sessionFactory;
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void add(String surname, String name) {
        Set<Employees> allEmployees = new HashSet<>(employeeDao.getAll());

        Employees employee = new Employees();
        employee.setName(name);
        employee.setSurname(surname);

        if(!allEmployees.contains(employee)) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            System.out.println("Successfully saved new Employee to DB");
        }
    }

    @Override
    @Transactional
    public void delete(Employees employee) {
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(employeeDao.getById(id));
            session.getTransaction().commit();
            System.out.println("Employee deleted from DB");
        }catch (RuntimeException e){
            System.out.println("No Employee in DB to delete");
        }
        return 1;
    }

    @Override
    @Transactional
    public List<Employees> getByName(String name) {
//        Session session = sessionFactory.getCurrentSession();
////        Query query = session.createNativeQuery("select * from Employees where name=:name");
//        Query query = session.createQuery("select e from " + Employees.class.getName() + " e where e.name like :name");
////        Query query = session.createQuery("select e from Employees e where e.name like :name");
//        query.setParameter("name", name);
//        return query.getResultList();

        List<Employees> employees = new ArrayList<>();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Query query = sessionFactory.openSession().createQuery("select e from Employees e where e.name like :name");
        query.setParameter("name", name);
        employees = query.getResultList();

        if (employees == null || employees.size() == 0) {
            throw new RuntimeException("Cannot find Employee with name: " + name);
        }
        return employees;
    }

    @Override
    public Employees getById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("select e from Employees e where e.id like :id");
//        query.setParameter("id", id);
//        return (Employees) query.uniqueResult();

        Session session = null;
        Employees employee = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            employee = session.load(Employees.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception 'findById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employee;

//        sessionFactory = new Configuration().configure().buildSessionFactory();
//        Query query = sessionFactory.openSession().createQuery("select e from " + Employees.class.getName() + " e where e.name like :name");
//        query.setParameter("name", name);
//        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Employees> getAll() {
//        return sessionFactory.getCurrentSession().createQuery("select e from Employees e").list();

//        Session session = null;
//        List <Employees> employees = new ArrayList<Employees>();
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            employees = session.createCriteria(Employees.class).list();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception 'getAll'", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return employees;

//        sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        return session.createCriteria(Employees.class).list();

        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.openSession().createQuery("select e from Employees e").list();

    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
