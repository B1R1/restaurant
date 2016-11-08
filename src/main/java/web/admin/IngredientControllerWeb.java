package web.admin;

import model.Ingredient;
import model.controllers.IngredientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class IngredientControllerWeb {

    @Autowired
    private IngredientController ingredientController;

    @RequestMapping(value="/ingredients")
    public ModelAndView listIngredient(ModelAndView model) throws IOException {
        List<Ingredient> listIngredient = ingredientController.getAll();
        model.addObject("listIngredient", listIngredient);
        model.setViewName("admin/ingredients");
        return model;
    }

    @RequestMapping(value="/endingIngredient")
    public ModelAndView endingIngredient(ModelAndView model) throws IOException {
        List<Ingredient> endingIngredient = ingredientController.getRunningOut();
        model.addObject("endingIngredient", endingIngredient);
        model.setViewName("admin/ingredients");
        return model;
    }

    @RequestMapping(value = "/newIngredient", method = RequestMethod.GET)
    public ModelAndView newIngredient(ModelAndView model) {
        Ingredient ingredient = new Ingredient();
        model.addObject("ingredient", ingredient);
        model.setViewName("admin/ingredientForm");
        return model;
    }

    @RequestMapping(value = "/saveIngredient", method = RequestMethod.POST)
    public ModelAndView saveIngredient(@ModelAttribute Ingredient ingredient) {
        ingredientController.add(ingredient);
        return new ModelAndView("redirect:/ingredients");
    }

    @RequestMapping(value = "/deleteIngredient", method = RequestMethod.GET)
    public ModelAndView deleteIngredient(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        ingredientController.delete(ingredientController.getById(id));
        return new ModelAndView("redirect:/ingredients");
    }

    @RequestMapping(value = "/editIngredient", method = RequestMethod.GET)
    public ModelAndView editIngredient(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Ingredient ingredient = ingredientController.getById(id);
        ModelAndView model = new ModelAndView("admin/ingredientForm");
        model.addObject("ingredient", ingredient);
        return model;
    }

//    ????????????????????????


//    @RequestMapping("/ingredients")
//    public String printList(ModelMap model) {
//        model.addAttribute("ingredients",  ingredientController.getAll());
//        return "admin/ingredients";
//    }
//
//    @RequestMapping(value ="/ingredients/delete/{id}", method= RequestMethod.GET)
//    public String delete(@PathVariable("id") int id, ModelMap model) {
//        ingredientController.delete(ingredientController.getById(id));
//        return "redirect: /ingredients";
//    }
//
//    @RequestMapping(value = "/ingredients/edit/{id}", method=RequestMethod.GET)
//    public String edit(@PathVariable("id")int id, ModelMap model) {
//        model.addAttribute("ingredientsTwo", ingredientController.getAll());
//        model.addAttribute("ingredient", ingredientController.getById(id));
//        return "admin/ingredient";
//    }
//
//    @RequestMapping(value = "/ingredients/search", method=RequestMethod.GET)
//    public String find(@RequestParam("name")String name, ModelMap model) {
//        model.addAttribute("ingredients", ingredientController.getByName(name));
//        return "admin/ingredients";
//    }
//
//    @RequestMapping(value = "/ingredients/runningout", method=RequestMethod.GET)
//    public String getRunningOut(ModelMap model) {
//        model.addAttribute("ingredients", ingredientController.getRunningOut());
//        return "admin/ingredients";
//    }
//
//    @RequestMapping(value = "/ingredient", method = RequestMethod.GET)
//    public String create(ModelMap model) {
//        model.addAttribute("ingredientsTwo", ingredientController.getAll());
//        model.addAttribute("ingredient", new Ingredient());
//        return "admin/ingredient";
//    }
//
//    @RequestMapping(value = "/ingredient", method = RequestMethod.POST)
//    public String submit(@ModelAttribute("ingredient") Ingredient ingredient) {
//        ingredientController.add(ingredient);
//        return "redirect:/ingredients";
//    }
}
