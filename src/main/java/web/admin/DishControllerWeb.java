package web.admin;

import model.Dishes;
import model.Ingredient;
import model.controllers.DishController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class DishControllerWeb {

    @Autowired
    private DishController dishController;

    @RequestMapping(value="/dishes")
    public ModelAndView listIngredient(ModelAndView model) throws IOException {
        List<Dishes> listDishes = dishController.getAllDishes();
        model.addObject("listDishes", listDishes);
        model.setViewName("admin/dishes");
        return model;
    }

    @RequestMapping(value = "/newDish", method = RequestMethod.GET)
    public ModelAndView newDishes(ModelAndView model) {
        Dishes dish = new Dishes();
        model.addObject("dish", dish);
        model.setViewName("admin/dishForm");
        return model;
    }

    @RequestMapping(value = "/saveDish", method = RequestMethod.POST)
    public ModelAndView saveDish(@ModelAttribute Dishes dish) {
        dishController.add(dish);
        return new ModelAndView("redirect:/dishes");
    }

    @RequestMapping(value = "/deleteDish", method = RequestMethod.GET)
    public ModelAndView deleteDish(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        dishController.deleteById(id);
        return new ModelAndView("redirect:/dishes");
    }

    @RequestMapping(value = "/editDish", method = RequestMethod.GET)
    public ModelAndView editDish(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Dishes dish = dishController.getById(id);
        ModelAndView model = new ModelAndView("admin/ingredientForm");
        model.addObject("ingredient", dish);
        return model;
    }
}
