package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ready_dishes")
public class ReadyDish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy="increment")
    @Column(name = "dish_id")
    private int dishId;
    @Column(name = "dish_name")
    private String dishName;
    @Column(name = "chef_id")
    private int cookId;
    @Column(name = "order_id")
    private int orderId;

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
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
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", cookId=" + cookId +
                ", orderId=" + orderId +
                '}';
    }
}
