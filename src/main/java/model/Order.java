package model;

import java.util.List;

public class Order {
    private int orderId;
    private int waiterId;
    private List<String> dishes;
    private int tableNumber;
    private String date;
    private boolean isOpen; // HAVE TO ADD TO TABLE

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public List<String> getDishes() {
        return dishes;
    }

    public void setDishes(List<String> dishes) {
        this.dishes = dishes;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", waiter=" + waiterId +
                ", dishesList=" + dishes +
                ", tableNumber=" + tableNumber +
                ", date='" + date + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }
}
