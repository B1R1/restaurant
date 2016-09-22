package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ready_dishes")
public class ReadyDish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy="increment")
    @Column(name = "id")
    private int id;

    @Column(name = "dish_id")
    private int dishId;

    @Column(name = "cook_id")
    private int cookId;

    @Column(name = "order_id")
    private int orderId;

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getCookId() {
        return cookId;
    }

    public void setCookId(int cookId) {
        this.cookId = cookId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderNumber) {
        this.orderId = orderNumber;
    }

    @Override
    public String toString() {
        return "ReadyDish{" +
                "id=" + id +
                ", dishId=" + dishId + '\'' +
                ", cookId=" + cookId +
                ", orderId=" + orderId +
                '}';
    }
}
