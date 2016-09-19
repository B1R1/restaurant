import model.DishDao;
import model.controllers.*;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;
    private IngredientController ingredientController;
    private MenuController menuController;

    private SessionFactory sessionFactory;

    private DishDao dishDao;

    private boolean reInit;


    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = context.getBean("main", Main.class);
        main.start();
    }

    public void init(){
        if(reInit){
            List<String> dishes = new ArrayList<>();
            dishes.add("Plov");
            dishes.add("Salad");
            orderController.createOrder(1, dishes, 1);
        }
    }
    private void start() {
        System.out.println("-----------START----------");
//        employeeController.getAll().forEach(System.out::println);
//        System.out.println("===========================");
//        dishController.getAllDishes().forEach(System.out::println);
                System.out.println("===========================");
//        System.out.println(menuController.getAll());
//        System.out.println(menuController.getMenuByName("mexican"));
//        System.out.println(dishDao.getByName("HHHH"));
        menuController.deleteDish("mexican", "HHHH");
//        menuController.addMenu();
//        menuController.deleteMenu();
        System.out.println("-----------FINISH---------");

//        System.out.println("===========================");
//        employeeController.getAll().forEach(System.out::println);

//        dishController.getAllDishes().forEach(System.out::println);
//
//        System.out.println(employeeController.getByName("John"));
//        System.out.println(dishController.getDish("Plov"));
//
//        orderController.getAll().forEach(System.out::println);
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setIngredientController(IngredientController ingredientController) {
        this.ingredientController = ingredientController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setReInit(boolean reInit) {
        this.reInit = reInit;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}