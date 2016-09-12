package model;

import java.util.List;

public interface DishDao {

    void save(Dishes dish);
    void add(String dishName, String category);
    int deleteByName(String name);
    Dishes findByName(String name);
    List<Dishes> getAll();
}
