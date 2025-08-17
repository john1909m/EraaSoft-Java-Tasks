package Services.impls;

import Data.DishData;
import Data.OrderData;
import Data.UserData;
import Models.Customer;
import Models.Dish;
import Models.Order;
import Services.interfaces.CustomerService;
import Services.interfaces.Registerable;
import Services.interfaces.UserService;

public class CustomerServiceImpl implements CustomerService, Registerable, UserService {
    private Customer customer;
    public CustomerServiceImpl(Customer customer) {
        this.customer = customer;

    }
    public CustomerServiceImpl() {

    }
    @Override
    public void register(String username,String password){
        Customer newCustomer=new Customer(username,password);
        UserData.addCustomer(newCustomer);
        System.out.println("Customer registered successfully for "+username);
    }
    @Override
    public boolean login(String username,String password){
        for(Customer c:UserData.getCustomers()){
            if(c.getUsername().equals(username)&&c.getPassword().equals(password)){
                customer=c;
                System.out.println("Customer logged successfully for "+username);
                return true;
            }
        }
        System.out.println("Login failed");
        return false;
    }
    public Customer getLoggedInCustomer() {
        return customer;
    }
    @Override
    public void viewMenu(){
        DishData.printMenu();

    }
    @Override
    public void makeOrder(String dishName,int quantity){
        Dish dish=DishData.getDishByName(dishName);
        if(dish==null){
            System.out.println("Invalid dish name "+dishName);
            return;
        }
        Order order=new Order(dish,quantity,customer);
        customer.getOrders().add(order);
        OrderData orderData=new OrderData();
        orderData.addOrder(order);
        System.out.println("Order "+dish.getDishName()+" has been created");
    }


}
