package model.controllers;

import model.DishToMenuDao;
import model.DishesToMenu;
import org.springframework.transaction.annotation.Transactional;

public class DishToMenuController {

    private DishToMenuDao dishToMenuDao;

    @Transactional
    public void delete(DishesToMenu dishesToMenu){
        dishToMenuDao.delete(dishesToMenu);
    }

    @Transactional
    public void deleteDish(int menuId, int dishId) {
        dishToMenuDao.deleteDish(menuId, dishId);
    }

    @Transactional
    public DishesToMenu getById(int id){
        return dishToMenuDao.getById(id);
    }

    public void setDishToMenuDao(DishToMenuDao dishToMenuDao) {
        this.dishToMenuDao = dishToMenuDao;
    }
}
