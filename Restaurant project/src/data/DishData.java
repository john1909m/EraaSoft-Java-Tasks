package data;

import Models.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishData {
    private static List<Dish> dishes=new ArrayList<Dish>();
    static {
        dishes.add(new Dish("Burger", 55.0));
        dishes.add(new Dish("Pizza", 80.0));
        dishes.add(new Dish("Pasta", 65.0));
        dishes.add(new Dish("Fries", 25.0));
        dishes.add(new Dish("Cola", 15.0));
        dishes.add(new Dish("Cheese", 12.0));
    }
    public static void addDish(Dish dish){
        dishes.add(dish);
    }
    public static List<Dish> getDishes(){
        return dishes;
    }
    public static void printMenu() {
        System.out.println("------ MENU ------");
        for (Dish dish : dishes) {
            System.out.println("ID: " + dish.getId() +
                    " | Name: " + dish.getName() +
                    " | Price: $" + dish.getPrice());
        }
        System.out.println("------------------");
    }

    public static Dish getDishByName(String name) {
        for (Dish dish : dishes) {
            if (dish.getName().equalsIgnoreCase(name)) {
                return dish;
            }
        }
        return null;
    }

    public static Dish getDishById(int id) {
        for (Dish dish : dishes) {
            if (dish.getId() == id) {
                return dish;
            }
        }
        return null;
    }

    public static boolean editDish(String oldName, String newName, double newPrice) {
        Dish dish = getDishByName(oldName);
        if (dish != null) {
            dish.setName(newName);
            dish.setPrice(newPrice);
            return true;
        }
        return false;
    }
}
