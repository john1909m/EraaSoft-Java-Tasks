package Data;

import Models.Dish;
import Models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderData {
    private static List<Order> orders=new ArrayList<>();
    public void addOrder(Order order){
        orders.add(order);
    }
    public List<Order> getOrders(){
        return orders;
    }
    public  List<Order> getOrderByStatus(String status){
        List<Order> result=new ArrayList<>();
        for (Order order: orders) {
            if(order.getOrderStatus().equals(status)){
                result.add(order);
            }
        }
        return result;
    }
    public static Order getOrderById(int id){
        for (Order order : orders) {
            if(order.getId()==id){
                return order;
            }
        }
        return null;
    }
}
