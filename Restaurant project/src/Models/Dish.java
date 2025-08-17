package Models;

public class Dish {
    private String name;
    private int id;
    double price;
    private static int idCounter = 1;

    public Dish(String name, double price) {
        this.id=idCounter++;
        this.name = name;
        this.price = price;
    }
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
