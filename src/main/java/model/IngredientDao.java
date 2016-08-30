package model;

import java.util.List;

public interface IngredientDao {

    void addIngredient(String name);
    void deleteByName(String name);
    Ingredient getByName(String name);
    List<Ingredient> getAll();

}
