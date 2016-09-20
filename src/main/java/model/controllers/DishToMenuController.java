package model.controllers;

import model.DishToMenuDao;
import org.springframework.transaction.annotation.Transactional;

public class DishToMenuController {

    private DishToMenuDao dishToMenuDao;

    @Transactional
    public void deleteDish(int menuId, int dishId) {
        dishToMenuDao.deleteDish(menuId, dishId);

    }

    public void setDishToMenuDao(DishToMenuDao dishToMenuDao) {
        this.dishToMenuDao = dishToMenuDao;
    }
}
