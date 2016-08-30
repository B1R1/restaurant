package model;

import java.util.HashMap;

public class Storage {

    private HashMap<Ingredient, Integer> ingredientList;

    public HashMap<Ingredient, Integer> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(HashMap<Ingredient, Integer> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "ingredientList=" + ingredientList +
                '}';
    }
}
