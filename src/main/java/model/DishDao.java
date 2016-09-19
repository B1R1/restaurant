package model;

import java.util.List;

public interface DishDao {

    void add(Dishes dish);
    void add(String dishName, String category);
    int deleteByName(String name);
    Dishes getByName(String name);
    List<Dishes> getAll();
}
