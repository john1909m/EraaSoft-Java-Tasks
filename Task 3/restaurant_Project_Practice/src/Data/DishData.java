package Data;

import Models.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishData {
    private static List<Dish> dishes=new ArrayList<Dish>();
    static {
        dishes.add(new Dish("Pizza",300));
        dishes.add(new Dish("Chicken",150));
        dishes.add(new Dish("Burger",200));
        dishes.add(new Dish("Cheese",50));
        dishes.add(new Dish("Shawerma",85));
        dishes.add(new Dish("Pepsi",20));
        dishes.add(new Dish("Fries",45));
    }
    public static void addDish(Dish dish) {
        dishes.add(dish);
    }

    public static List<Dish> getDishes() {
        return dishes;
    }
    public static void printMenu(){
        System.out.println("----------------------Menu-----------------------");
        for (Dish dish : dishes) {
            System.out.println("ID: "+dish.getDishId()+" | Name: "+ dish.getDishName()+" | Price: "+dish.getDishPrice()+" EGP");

        }
        System.out.println("----------------------------------------------");
    }
    public static Dish getDishByName(String dishName){
        for (Dish dish : dishes) {
            if(dish.getDishName().equals(dishName)){

                return dish;
            }
        }
        return null;
    }
    public static Dish getDishById(int dishId){
        for (Dish dish : dishes) {
            if(dish.getDishId()==dishId){
                return dish;

            }
        }
        return null;
    }
    public static boolean editDish(String oldDishName,String newDishName,double price){
        Dish dish=getDishByName(oldDishName);
        if(dish!=null){
            dish.setDishName(newDishName);
            dish.setDishPrice(price);
            return true;
        }
        return false;
    }
}
