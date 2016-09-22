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

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees waiter;

    @ManyToMany
    @JoinTable(
            name = "ready_dishes",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dishes> readyDishes;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "date")
    private Date date;

    @Column(name = "isopen")
    private boolean isOpen;

    public int getId() {
        return id;
    }

    public void setId(int orderId) {
        this.id = orderId;
    }

    public Employees getWaiter() {
        return waiter;
    }

    public void setWaiter(Employees waiter) {
        this.waiter = waiter;
    }

    public List<Dishes> getReadyDishes() {
        return readyDishes;
    }

    public void setReadyDishes(List<Dishes> readyDishes) {
        this.readyDishes = readyDishes;
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
                "id=" + id  + '\n' +
                "\twaiter=" + waiter +
                ", readyDishes=" + readyDishes + '\n' +
                ", tableNumber=" + tableNumber +
                ", date='" + date + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }
}
