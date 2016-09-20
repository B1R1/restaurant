package model.controllers;

import model.Dishes;
import model.DishDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DishController  {

    private DishDao dishDao;

    @Transactional
    public void add(Dishes dish){
        dishDao.add(dish);
    }

    @Transactional
    public void delete(String name){
        dishDao.deleteByName(name);
    }

    @Transactional
    public Dishes getDish(String name){
        return dishDao.getByName(name);
    }

    @Transactional
    public List<Dishes> getAllDishes(){
        return dishDao.getAll();
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
