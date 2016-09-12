package model;

import javax.persistence.Entity;
import java.util.HashMap;

@Entity
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
