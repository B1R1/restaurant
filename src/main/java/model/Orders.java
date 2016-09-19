package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy="increment")
    @Column(name = "id")
    private int id;

    @Column(name = "order_number")
    private int orderNumber;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees waiter;

    @ManyToMany
    @JoinTable(
            name = "ready_dishes",
            joinColumns = @JoinColumn(name = "order_id"), // ид нашего объекта
            inverseJoinColumns = @JoinColumn(name = "dish_id") // ид объекта с которым связываемся
    )
    private List<Dishes> dishes;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "date")
    private Date date;

    @Column(name = "isOpen")
    private boolean isOpen;

    public int getId() {
        return id;
    }

    public void setId(int orderId) {
        this.id = orderId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Employees getWaiter() {
        return waiter;
    }

    public void setWaiter(Employees waiter) {
        this.waiter = waiter;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", waiter=" + waiter +
                ", dishes=" + dishes +
                ", tableNumber=" + tableNumber +
                ", date='" + date + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }
}
