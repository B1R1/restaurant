package web.client;

import model.Employees;
import model.controllers.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WaiterController {

    private EmployeeController employeeController;

    @RequestMapping(value =  "/waiters", method = RequestMethod.GET)
    public String employees(Map<String, Object> model){
//        List<Employees> employees = employeeController.getAll();
//        List<Employees> waiters = new ArrayList<>();
//        for (Employees item : employees) {
//            if (item.getPosition().equals("WAITER")) {
//                waiters.addMenu(item);
//            }
//        }
        model.put("waiters", employeeController.getAll());
        return "client/waiters";
    }

//    @RequestMapping(value = "/waiters", method = RequestMethod.GET)
//    public String getAllWaiters(Model model)
//    {
//        model.addAttribute("employeeList", employeeController.getAll());
//        model.addAttribute("selectedEmployees", new Employees());
//        return "client/waiters";
//    }
//
//    @RequestMapping(value = "/waiters", method = RequestMethod.POST)
//    public String getAllWaitersAction(@ModelAttribute("selectedEmployees") Employees selectedEmployee, Model model)
//    {
//        // if u need only selected user id just use it
//        System.out.println("Selected employees: " + selectedEmployee.getName());
//
//        // if u need whole user object take it from database using id
//        selectedEmployee = employeeController.getById(selectedEmployee.getId());
//        System.out.println("Selected employees: " + selectedEmployee);
//
//        return "redirect:/";
//    }

    @Autowired
    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
