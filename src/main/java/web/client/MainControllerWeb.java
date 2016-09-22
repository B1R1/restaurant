package web.client;

import model.Menu;
import model.controllers.MenuController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainControllerWeb {

    private MenuController menuController;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String printContacts (ModelMap model) {
        model.addAttribute("name", "Azure Restaurant & Bar");
        model.addAttribute("address", "Address: 225 Front Street West, Toronto, Ontario M5V 2X3");
        model.addAttribute("phone", "Phone: 1-416-597-8142");
        model.addAttribute("email", "Email: azure@ihg.com");

        return "client/main";
    }

    @RequestMapping(value = "/main/menu", method = RequestMethod.GET)
    public String printMenu (ModelMap model) {
        model.addAttribute("name", "Azure Restaurant & Bar");

//        Menu menu = new Menu();
//        menu = menuController.getAll().get(1);
//
//        model.addAttribute("currentMenu", menu.toString());
        return "redirect:/client/main";
    }




        @Autowired
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
}
