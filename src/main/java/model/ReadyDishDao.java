package model;

import java.util.List;

public interface ReadyDishDao {

    int add(int dishNumber, String dishName, int chefId, int orderNumber);
    List<ReadyDish> getAll();
}
