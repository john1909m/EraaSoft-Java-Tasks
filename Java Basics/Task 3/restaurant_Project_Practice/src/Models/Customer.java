package Models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Order> orders;

    public Customer(String username, String password) {
        super(username, password);
        this.orders = new ArrayList<Order>();
    }
    public void viewMenu(List<Dish> menu){
        System.out.println("--------------------------Menu--------------------------");
        for (Dish dish : menu) {
            System.out.println("ID: "+dish.getDishId()+" | Name: "+ dish.getDishName()+" | Price: "+dish.getDishPrice()+" EGP");
        }
        System.out.println("----------------------------------------------------");
    }
    public void makeOrder(Dish dish,int quantity) {
        Order order=new Order(dish,quantity,this);
        orders.add(order);
        System.out.println("Order"+ dish.getDishName() +" X"+quantity + "has been placed in order");
    }

    public List<Order> getOrders() {
        for(Order order:orders){
            System.out.println(order.getDish().getDishName()+" X"+order.getQuantity());
        }
        return orders;
    }
}
