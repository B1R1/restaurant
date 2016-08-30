import model.jdbc.JdbcEmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private JdbcEmployeeDao employeeDao;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean("main", Main.class);
        main.start();
    }

    private void start() {
        employeeDao.getAllEmployee().forEach(System.out::println);
        System.out.println(employeeDao.getEmployeeByName("Rustam"));
    }

    public void setEmployeeDao(JdbcEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}