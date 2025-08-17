package services.impl;

import Models.Chef;
import Models.Dish;
import Models.Order;
import Models.OrderStatus;
import data.DishData;
import data.OrderData;
import services.interfaces.ChefService;

import java.util.ArrayList;
import java.util.List;

public class ChefServiceImpl implements ChefService {
    private Chef chef;
    public void ChefServiceImpl(Chef chef) {
        this.chef=chef;
    }
    @Override
    public void addDish(String dishName,double price) {
         Dish dish=new Dish(dishName,price);
         DishData.addDish(dish);
         System.out.println("Dish "+dishName+" has been added successfully");

    }
    @Override
    public void editDish(String name,String newName,double newPrice){
        boolean found=false;
        for(Dish dish:DishData.getDishes()){
            if(dish.getName().equals(name)){
                dish.setName(newName);
                dish.setPrice(newPrice);
                found=true;
                break;
            }

        }
        if(!found){
            System.out.println("Dish "+newName+" not found");
        }
        else {
            System.out.println("Dish "+newName+" has been updated successfully");
        }
    }


    @Override
    public void viewOrder(){
        OrderData orderData=new OrderData();
        List<Order> orders= orderData.getOrders();
        System.out.println("-------- All Orders -------");
        for(Order order:orders){
            System.out.println("ID: " + order.getId() +
                    " | Dish: " + order.getDish().getName() +
                    " | Qty: " + order.getQuantity() +
                    " | Status: " + order.getStatus() +
                    " | Customer: " + order.getCustomer().getUsername());
        }
        System.out.println("---------------");
    }
    @Override
    public void updateOrderStatus(int orderId, OrderStatus status){
        OrderData orderData=new OrderData();
        Order order=orderData.getOrderById(orderId);
        if(order!=null){
            order.setStatus(status);
            System.out.println("Order #" + orderId + " updated to: " + status);

        }else  {
            System.out.println("Order #" + orderId + " not found");
        }
    }


}
