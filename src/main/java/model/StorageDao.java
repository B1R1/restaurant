package model;

import java.util.Map;

public interface StorageDao {

    int addIngredient(String name, int amount);
    int deleteIngredient(String name);
    int changeAmount(String name, int neededToRemoveAmount);
    Ingredient getByName(String name);
    Map<Ingredient, Integer> getAll();
    Map<Ingredient, Integer> getAllFinishingIngredients(int amount);
}
