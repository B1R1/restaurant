package model;

import java.util.List;

public interface MenuDao {

    void add(String name);

    int deleteByName(String name);

    void addDish(String menuName, String dishName);

    int deleteDish(String menuName, String dishName);

    Menu findByName(String name);

    List<Menu> getAll();
}
