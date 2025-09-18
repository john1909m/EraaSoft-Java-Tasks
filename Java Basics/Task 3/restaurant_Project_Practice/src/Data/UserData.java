package Data;

import Models.Chef;
import Models.Customer;
import Models.DeliveryGuy;
import Models.Order;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private static List<Customer> customers=new ArrayList<>();
    private static List<Chef> chefs=new ArrayList<>();
    private static List<DeliveryGuy> guys=new ArrayList<>();
    static{
        customers.add(new Customer("John","123456"));
        chefs.add(new Chef("Ahmed","123456"));
        guys.add(new DeliveryGuy("Karim","123456"));

    }
    public static void addCustomer(Customer customer){
        customers.add(customer);
    }
    public static void addChef(Chef chef){
        chefs.add(chef);
    }
    public static void addDeliveryGuy(DeliveryGuy deliveryGuy){
        guys.add(deliveryGuy);
    }
    public static Customer getCustomerByName(String name){
        for(Customer customer : customers){
            if (customer.getUsername().equals(name)){
                return customer;
            }
        }
        return null;
    }
    public static Chef getChefByName(String name){
        for(Chef chef : chefs){
            if (chef.getUsername().equals(name)){
                return chef;
            }
        }
        return null;
    }
    public static DeliveryGuy getDeliveryGuyByName(String name){
        for(DeliveryGuy deliveryGuy : guys){
            if (deliveryGuy.getUsername().equals(name)){
                return deliveryGuy;
            }
        }
        return null;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }
    public static List<Chef> getChefs() {
        return chefs;
    }
    public static List<DeliveryGuy> getDeliveryGuys() {
        return guys;
    }
    public static Customer findCustomer(String username,String password){
        for(Customer customer : customers){
            if (customer.getUsername().equals(username)&&customer.getPassword().equals(password)){
                return customer;
            }
        }
        return null;
    }
    public static Chef findChef(String username,String password){
        for(Chef chef : chefs){
            if (chef.getUsername().equals(username)&&chef.getPassword().equals(password)){
                return chef;
            }
        }
        return null;
    }
    public static DeliveryGuy findDeliveryGuy(String username,String password){
        for(DeliveryGuy deliveryGuy : guys){
            if(deliveryGuy.getUsername().equals(username)&&deliveryGuy.getPassword().equals(password)){
                return deliveryGuy;
            }
        }
        return null;
    }



}


