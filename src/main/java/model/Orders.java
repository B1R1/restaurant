package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy="increment")
    @Column(name = "order_number")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private int waiterId;

    @ManyToMany
    @JoinTable(
            name = "ready_dishes",
            joinColumns = @JoinColumn(name = "order_number"), // ид нашего объекта
            inverseJoinColumns = @JoinColumn(name = "dish_name") // ид объекта с которым связываемся
    )
    private List<Dishes> dishes;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "date")
    private String date;

    @Column(name = "isOpen")
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

    public List<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dishes> dishes) {
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
        return "Orders{" +
                "orderId=" + orderId +
                ", waiter=" + waiterId +
                ", dishesList=" + dishes +
                ", tableNumber=" + tableNumber +
                ", date='" + date + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }
}
