package model;

import java.util.List;

public interface DishDao {

    void add(Dishes dish);
    void add(String dishName, String category);
    void deleteByName(String name);
    void deleteById(int id);
    Dishes getById(int id);
    Dishes getByName(String name);
    List<Dishes> getAll();
}
