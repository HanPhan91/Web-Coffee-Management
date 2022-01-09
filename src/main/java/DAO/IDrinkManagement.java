package DAO;

import Model.Drink;
import Model.Staff;

import java.util.List;

public interface IDrinkManagement {
    public List<Drink> selectAllDrink();
    public List<Drink> selectDrinkActive();
    public Drink selectDrink(int id);
    public boolean addDrink(Drink newDrink);
    public boolean editDrink(Drink editDrink);
    public boolean removeDrink(int id);
    public boolean activeDrink(int id);
}
