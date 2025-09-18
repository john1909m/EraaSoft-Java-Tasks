package Models;

public class Dish {
    private int id;
    private String name;
    private double price;
    private static int idCounter=1;
    public Dish( String name, double price) {
        id = idCounter++;
        this.name = name;
        this.price = price;

    }
    public int getDishId() {
        return id;
    }
    public String getDishName() {
        return name;
    }
    public double getDishPrice() {
        return price;
    }
    public void setDishName(String name) {
        this.name = name;
    }
    public void setDishPrice(double price) {
        this.price = price;
    }
}
