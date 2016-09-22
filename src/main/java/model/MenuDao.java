package model;

import java.util.List;

public interface MenuDao {

    void add(Menu menu);
    void addMenu(String name);
    void deleteMenu(int id);
    void addDish(String menuName, String dishName);
    int deleteDish(String menuName, String dishName);
    Menu getMenuByName(String name);
    Menu getMenuById(int id);
    List<Menu> getAll();
}
