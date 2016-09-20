package model;

public interface DishToMenuDao {

    void deleteDish(int menuId, int dishId);
    DishesToMenu getById(int id);
}
