package web;

import model.controllers.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
//@ResponseBody  // одна на все методы
//@RestController // одна вместо двух на класс: @Controller и @ResponseBody
public class EmployeeControllerWeb {

    private EmployeeController employeeController;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model){
        model.put("employees", employeeController.getAll());
        return "employees"; //jsp с таким именем
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView employee(@RequestParam("employeeName") String name){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeController.getByNameReturnEmployee(name));
        modelAndView.setViewName("employee");
        return modelAndView;
    }

//    @RequestMapping(value = "/employees", method = RequestMethod.GET)
//    @ResponseBody // говорит: mvc не ищи view, а редиректь эти данные
//    public List<Employees> employee(Map<String, Object> model){
//        model.put("employees", employeeController.getAll());
//        return employeeController.getAll();
//    }


//    @RequestMapping(value = "/employee/{name}", method = RequestMethod.GET)
//    @ResponseBody
//    public Employees employees(@PathVariable String name){
//        Employees result = (Employees) employeeController.getByName(name);
//        return result;
//    }

    @Autowired
    public void setEmployeeController(model.controllers.EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
