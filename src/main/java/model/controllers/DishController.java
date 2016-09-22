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
    public void deleteByName(String name){
        dishDao.deleteByName(name);
    }

    @Transactional
    public void deleteById(int id){
        dishDao.deleteById(id);
    }

    @Transactional
    public Dishes getByName(String name){
        return dishDao.getByName(name);
    }

    @Transactional
    public Dishes getById(int id){
        return dishDao.getById(id);
    }

    @Transactional
    public List<Dishes> getAllDishes(){
        return dishDao.getAll();
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
