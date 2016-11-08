package model.controllers;

import model.Ingredient;
import model.IngredientDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class IngredientController {

    private IngredientDao ingredientDao;

    @Transactional
    public void add(Ingredient ingredient){
        ingredientDao.add(ingredient);
    }

    @Transactional
    public void addByName(String name){
        ingredientDao.addByName(name);
    }

    @Transactional
    public void delete(Ingredient ingredient){
        ingredientDao.delete(ingredient);
    }

    @Transactional
    public void deleteByName(String name){
        ingredientDao.deleteByName(name);
    }

    @Transactional
    public Ingredient getByName(String name){
        return ingredientDao.getByName(name);
    }

    @Transactional
    public Ingredient getById(int id){
        return ingredientDao.getById(id);
    }

    @Transactional
    public List<Ingredient> getRunningOut() {
        return ingredientDao.getRunningOut();
    }

    @Transactional
    public List<Ingredient> getAll(){
        return ingredientDao.getAll();
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
