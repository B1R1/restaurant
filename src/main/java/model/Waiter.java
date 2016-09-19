package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity // название таблички указывать не надо, при других стратегиях - надо
public class Waiter extends Employees {

    @OneToMany()
    @JoinColumn(name = "employee_id") // колонка в таблице Orders
    public List<Orders> getOrders() {
        return orders;
    }

    private List<Orders> orders;

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "orders=" + orders +
                '}';
    }
}
