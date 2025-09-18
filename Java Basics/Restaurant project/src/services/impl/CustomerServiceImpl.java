package services.impl;

import Models.Customer;
import Models.Dish;
import Models.Order;
import data.DishData;
import data.OrderData;
import services.interfaces.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private Customer customer;

    public CustomerServiceImpl(Customer customer) {
        this.customer = customer;
    }
    @Override
    public void viewMenu(){
        DishData.printMenu();
    }

    @Override
    public void viewOrder() {

    }

    @Override
    public void makeOrder(String dishName, int quantity){
        Dish dish =DishData.getDishByName(dishName);
        if(dish == null){
            System.out.println("Invalid dish name "+dishName);

            return;
        }
        Order order = new Order(dish,quantity,customer);
        customer.getOrders().add(order);
        OrderData orderData = new OrderData();
        orderData.addOrder(order);
        System.out.println("Order has been placed successfully");
    }
}
