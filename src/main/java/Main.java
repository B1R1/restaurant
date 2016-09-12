import model.controllers.DishController;
import model.controllers.EmployeeController;
import model.controllers.IngredientController;
import model.controllers.OrderController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;
    private IngredientController ingredientController;

    private boolean reInit;


    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean("main", Main.class);
        main.start();
    }

    public void init(){
        if(reInit){
            employeeController.createEmployee();
            dishController.createDish();
            List<String> dishes = new ArrayList<>();
            dishes.add("Plov");
            dishes.add("Salad");
            orderController.createOrder(1, dishes, 1);
        }
    }
    private void start() {
        System.out.println("-----------START----------");
        employeeController.printAllEmployee();
//        employeeController.printEmployee("John");

//        employeeController.getAll().forEach(System.out::println);
//        dishController.getAllDishes().forEach(System.out::println);
//
//        System.out.println(employeeController.getByName("John"));
//        System.out.println(dishController.getDish("Plov"));
//
//        orderController.getAll().forEach(System.out::println);
        System.out.println("-----------FINISH---------");
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

    public void setReInit(String reInit) {
    }
}