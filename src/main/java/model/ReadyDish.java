package model;

import javax.persistence.Entity;

@Entity
public class ReadyDish {
    private int dishId;
    private String dishName;
    private int cookId;
    private int orderNumber;
    private String date;

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

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReadyDish{" +
                "dishId=" + dishId +
                ", dish=" + dishName +
                ", cook=" + cookId +
                ", order=" + orderNumber +
                ", date='" + date + '\'' +
                '}';
    }
}
