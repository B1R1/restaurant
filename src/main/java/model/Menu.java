package model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Menu {

    private int id;
    private String name;
    private List<Dishes> dishes; // NEW - HAVE TO ADD TO TABLE

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dishes> dishes) {
        this.dishes = dishes;
    }
}
