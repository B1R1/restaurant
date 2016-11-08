package model;

import java.util.List;

public interface IngredientDao {

    void add(Ingredient ingredient);
    void addByName(String name);
    void update(Ingredient ingredient);
    void delete(Ingredient ingredient);
    void deleteByName(String name);
    Ingredient getByName(String name);
    Ingredient getById(int id);
    List<Ingredient> getRunningOut();
    List<Ingredient> getAll();
}
