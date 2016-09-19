package model.controllers;

import model.Menu;
import model.MenuDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuController {

    private MenuDao menuDao;

    @Transactional
    public void addMenu(String name) {
        menuDao.addMenu(name);
    }

    @Transactional
    public void deleteMenu(String name){
        menuDao.deleteMenu(name);
    }

    @Transactional
    public void addDish(String menuName, String dishName){
        menuDao.addDish(menuName, dishName);
    }

    @Transactional
    public void deleteDish(String menuName, String dishName){
        menuDao.deleteDish(menuName, dishName);
    }

    @Transactional
    public Menu getMenuByName(String name){
        return menuDao.getMenuByName(name);
    }

    @Transactional
    public List<Menu> getAll(){
        return menuDao.getAll();
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
