package Models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private List<Order> orders;
    public Customer(String username, String password) {
        super(username, password);
        this.orders = new ArrayList<Order>();
    }
    public void viewMenu(List<Dish> menu){
        System.out.println("-------MENU-------");
        for (Dish dish : menu) {
            System.out.println("ID: " + dish.getId() +
                    " | Name: " + dish.getName() +
                    " | Price: $" + dish.getPrice());
        }
        System.out.println("--------------------");
    }
    public void makeOrder(Dish dish, int quantity){
        Order order=new Order(dish,quantity,this);
        orders.add(order);
        System.out.println("Order placed: " + quantity + " x " + dish.getName());


    }

    public List<Order> getOrders() {
        for(Order order:orders){
            System.out.println(order.getDish().getName());

        }
        return orders;
    }
}
