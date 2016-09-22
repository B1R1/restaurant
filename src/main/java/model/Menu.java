package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy="increment")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "dishes_to_menu",
            joinColumns = @JoinColumn(name = "menu_id"), //
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dishes> menuDishes;

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

    public List<Dishes> getMenuDishes() {
        return menuDishes;
    }

    public void setMenuDishes(List<Dishes> dishes) {
        this.menuDishes = dishes;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\n' +
                "\tdishes=" + menuDishes + '\n';
    }
}
