package web.client;

import model.Dishes;
import model.Menu;
import model.controllers.DishController;
import model.controllers.MenuController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class MainControllerWeb {

    @Autowired
    private MenuController menuController;

    @RequestMapping(value = "/menu&reservation")
    public ModelAndView printCurrentMenuDushes(ModelAndView model) throws IOException {
        Menu menu = menuController.getMenuByName("mexican");
        List<Dishes> listDishes = menu.getMenuDishes();
        model.addObject("listDishes", listDishes);

        model.addObject("name", "Azure Restaurant & Bar");
        model.addObject("address", "Address: 225 Front Street West, Toronto, Ontario M5V 2X3");
        model.addObject("phone", "Phone: 1-416-597-8142");
        model.addObject("email", "Email: azure@ihg.com");

        model.setViewName("client/menu&reservation");
        return model;
    }
}
