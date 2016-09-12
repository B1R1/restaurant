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
    public void createDish(){

        Set<Dishes> dishes = new HashSet<>(dishDao.getAll());

        Dishes plov = new Dishes();
        plov.setDishName("Plov");
        plov.setCategory("Main");
        plov.setPrice(5.00F);
        plov.setWeight(300F);


        Dishes salad = new Dishes();
        salad.setDishName("Salad");
        salad.setCategory("Salad");
        salad.setPrice(2.00F);
        salad.setWeight(200F);


        Dishes potato = new Dishes();
        potato.setDishName("Potato");
        potato.setCategory("Main");
        potato.setPrice(3.00F);
        potato.setWeight(100F);

        if(!dishes.contains(plov)){
            dishDao.save(plov);
        }

        if(!dishes.contains(salad)){
            dishDao.save(salad);
        }

        if(!dishes.contains(potato)){
            dishDao.save(potato);
        }
    }

    @Transactional
    public Dishes getDish(String name){
        return dishDao.findByName(name);
    }

    @Transactional
    public List<Dishes> getAllDishes(){
        return dishDao.getAll();
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
