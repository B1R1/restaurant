import model.Employees;
import model.hibernate.HEmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainFactory {

    private static HEmployeeDao employeeDao;

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        MainFactory mainFactory = context.getBean("mainFactory", MainFactory.class);
        mainFactory.start();
    }

    private void start() {
        System.out.println("=================");
        Employees employees = employeeDao.getById(2);
        System.out.println(employees.toString());
    }


    public void setEmployeeDao(HEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
