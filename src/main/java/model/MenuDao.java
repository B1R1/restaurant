package model;

import java.util.List;

public interface MenuDao {

    void addMenu(String name);
    int deleteMenu(String name);
    void addDish(String menuName, String dishName);
    int deleteDish(String menuName, String dishName);
    Menu getMenuByName(String name);
    List<Menu> getAll();
}
