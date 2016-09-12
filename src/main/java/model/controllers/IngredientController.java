package model.controllers;

import model.Ingredient;
import model.IngredientDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class IngredientController {

    private IngredientDao ingredientDao;

    @Transactional
    public Ingredient getByName(String name){
        return ingredientDao.getByName(name);
    }

    @Transactional
    public List<Ingredient> getAll(){
        return ingredientDao.getAll();
    }

    @Transactional
    public void printAll() {
        getAll().forEach(System.out::println);
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
