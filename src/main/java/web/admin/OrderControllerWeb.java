package web.admin;

import model.Ingredient;
import model.Orders;
import model.controllers.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class OrderControllerWeb {

    @Autowired
    private OrderController orderController;

    @RequestMapping(value="/orders")
    public ModelAndView printOrders(ModelAndView model) throws IOException {
        List<Orders> listOrders = orderController.getAll();
        model.addObject("listOrders", listOrders);
        model.setViewName("admin/orders");
        return model;
    }


}
