package web.admin;

import model.Menu;
import model.controllers.DishController;
import model.controllers.MenuController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuControllerWeb {

    @Autowired
    private MenuController menuController;
    @Autowired
    private DishController dishController;

    @RequestMapping("/menus")
    public String printList(ModelMap model) {
        model.addAttribute("menus", menuController.getAll());
        return "admin/menus";
    }

//    @RequestMapping(value = "/menu/see/{name}", method = RequestMethod.GET)
//    public ModelAndView employee(@RequestParam("menuName") String name){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("menu", menuController.getMenuByName(name));
//        modelAndView.setViewName("menu");
//        return modelAndView;
//    }

    @RequestMapping(value = "/menus/delete/{id}", method= RequestMethod.GET)
    public String delete(@PathVariable("id")int id, ModelMap model) {
        menuController.deleteMenu(id);
        return "redirect: /menus";
    }

    @RequestMapping(value = "/menus/edit/{id}", method=RequestMethod.GET)
    public String edit(@PathVariable("id")int id, ModelMap model) {
        model.addAttribute("allDishes", dishController.getAllDishes());
        model.addAttribute("menu", menuController.getMenuById(id));
        return "admin/menu";
    }

    @RequestMapping(value = "/menus/search", method=RequestMethod.GET)
    public String find(@RequestParam("name")String name, ModelMap model) {
        model.addAttribute("menus", menuController.getMenuByName(name));
        return "admin/menus";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String create(ModelMap model) {
        model.addAttribute("allDishes", dishController.getAllDishes());
        model.addAttribute("menu", new Menu());
        return "admin/menu";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public String submit(@ModelAttribute("menu") Menu menu) {
        menuController.add(menu);
        return "redirect: /menus";
    }
}
