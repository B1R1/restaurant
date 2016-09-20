package model;

import javax.persistence.*;

@Entity
@Table(name = "dishes_to_menu")
public class DishesToMenu {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @OneToOne
    @JoinColumn(name = "dish_id")
    private int dishId;

//    @OneToOne
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
