package model;

public interface DishToMenuDao {

    void delete (DishesToMenu dishesToMenu);
    void deleteDish(int menuId, int dishId);
    DishesToMenu getById(int id);
}
