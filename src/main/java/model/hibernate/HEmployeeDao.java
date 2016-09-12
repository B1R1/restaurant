package model.hibernate;

import model.Employees;
import model.EmployeeDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HEmployeeDao implements EmployeeDao{

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Employees employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Override
    @Transactional
    public void addNewEmployee(int id, String surname, String name) {

    }

    @Override
    @Transactional
    public void delete(Employees employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    @Transactional
    public int deleteEmployeeById(int id) {
        return 0;
    }

    @Override
    @Transactional
    public List<Employees> getEmployeeByName(String name) {
        System.out.println("-----------Метод в Хибернейте--------");
        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createNativeQuery("select * from Employees where name=:name");
        Query query = session.createQuery("select e from " + Employees.class.getName() + " e where e.name like :name");
//        Query query = session.createQuery("select e from Employees e where e.name like :name");
        query.setParameter("name", name);
        return query.getResultList();

//        Employees employee = sessionFactory.getCurrentSession().load(Employees.class, name);
//        if (employee == null) {
//            throw new RuntimeException("CAnnot find Employees with name: " + name);
//        }
//        return employee;
    }

    @Override
    public Employees getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employees e where e.id like :id");
        query.setParameter("id", id);
//        return (Employees) query.uniqueResult();
        return null;
    }

    @Override
    @Transactional
    public List<Employees> getAllEmployee() {
        return sessionFactory.getCurrentSession().createQuery("select e from Employees e").list();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
