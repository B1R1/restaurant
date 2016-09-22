package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "dishes_to_menu")
public class DishesToMenu {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy="increment")
    @Column(name = "id")
    private int id;

//    @Column(name = "dish_id")
    @JoinColumn(name = "dish_id")
    private int dishId;

//    @Column(name = "menu_id")
    @JoinColumn(name = "menu_id")
    private int menuId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishIn) {
        this.dishId = dishIn;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "DishesToMenu{" +
                "id=" + id +
                ", dishId=" + dishId +
                ", menuId=" + menuId +
                '}';
    }
}
