package model;

import java.util.List;

public interface DishDao {

    void add(String dishName, String category);

    int deleteByName(String name);

    Dish findByName(String name);

    List<Dish> getAll();
}
