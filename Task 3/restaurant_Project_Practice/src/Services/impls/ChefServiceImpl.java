package Services.impls;

import Data.DishData;
import Data.OrderData;
import Data.UserData;
import Models.Chef;
import Models.Dish;
import Models.Order;
import Models.OrderStatus;
import Services.interfaces.ChefService;
import Services.interfaces.UserService;

import java.util.List;


public class ChefServiceImpl implements ChefService, UserService {
    private static Chef chef;

    public ChefServiceImpl(Chef chef) {
        this.chef = chef;
    }
    public ChefServiceImpl() {

    }

    @Override
    public void addDish(String dishName, double price) {
        Dish dish = new Dish(dishName, price);
        DishData.addDish(dish);
        System.out.println("Dish "+dishName+" added successfully");
    }
    @Override
    public void editDish(String name, String newName, double newPrice) {
        boolean found=false;
        for (Dish dish:DishData.getDishes()) {
            if(dish.getDishName().equals(name)) {
                dish.setDishName(newName);
                dish.setDishPrice(newPrice);
                found=true;
                break;
            }
        }
        if(!found) {
            System.out.println("Dish "+name+" not found");
        }else  {
            System.out.println("Dish "+name+" updated successfully");
        }
    }

    @Override
    public boolean login(String username,String password){
        for(Chef c: UserData.getChefs()) {
            if(c.getUsername().equals(username)&&c.getPassword().equals(password)) {
                chef = c;
                System.out.println("User "+username+" logged in successfully");
                return true;
            }
        }
        System.out.println("User "+username+" not found");
        return false;

    }
    public Chef getLoogedInChef(){
        return chef;
    }

    @Override
    public void viewOrders() {
        OrderData orderData = new OrderData();
        List<Order> orders = orderData.getOrders();
        System.out.println("----------All Orders ----------");
        for (Order order:orders) {
            System.out.println("ID: " + order.getId() +
                    " | Dish: " + order.getDish().getDishName() +
                    " | Qty: " + order.getQuantity() +
                    " | Status: " + order.getOrderStatus() +
                    " | Customer: " + order.getCustomer().getUsername());
        }
        System.out.println("--------------------");
    }
    @Override
    public void updateOrderStatus(int orderId, OrderStatus status){

        Order order=OrderData.getOrderById(orderId);
        if(order!=null){
            order.setOrderStatus(status);
            System.out.println("Order #" + orderId + " updated to: " + status);

        }else  {
            System.out.println("Order #" + orderId + " not found");
        }
}
}
