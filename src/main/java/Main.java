import model.*;
import model.controllers.*;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;
    private IngredientController ingredientController;
    private MenuController menuController;
    private DishToMenuController dishToMenuController;

    private SessionFactory sessionFactory;

    private DishDao dishDao;
    private IngredientDao ingredientDao;
    private DishToMenuDao dishToMenuDao;

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


        orderController.getAll().forEach(System.out::println);

        System.out.println("===========================");


        System.out.println("-----------FINISH---------");

//        System.out.println("===========================");
//        employeeController.getAll().forEach(System.out::println);

//        dishController.getAllDishes().forEach(System.out::println);
//
//        System.out.println(employeeController.getByName("John"));
//        System.out.println(dishController.getByName("Plov"));
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

    public void setDishToMenuController(DishToMenuController dishToMenuController) {
        this.dishToMenuController = dishToMenuController;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void setDishToMenuDao(DishToMenuDao dishToMenuDao) {
        this.dishToMenuDao = dishToMenuDao;
    }
}