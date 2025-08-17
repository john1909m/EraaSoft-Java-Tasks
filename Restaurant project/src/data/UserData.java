package data;

import Models.Customer;
import Models.Chef;
import Models.DeliveryGuy;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Chef> chefs = new ArrayList<>();
    private static List<DeliveryGuy> deliveryGuys = new ArrayList<>();
    static {
        customers.add(new Customer("customer1", "1234"));
        chefs.add(new Chef("chef1", "1234"));
        deliveryGuys.add(new DeliveryGuy("delivery1", "1234"));
    }
    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void addChef(Chef chef) {
        chefs.add(chef);
    }

    public static void addDeliveryGuy(DeliveryGuy guy) {
        deliveryGuys.add(guy);
    }
    public static Customer getCustomerByUserName(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }
    public static Chef getChefByUserName(String username) {
        for (Chef chef : chefs) {
            if (chef.getUsername().equals(username)) {
                return chef;
            }
        }
        return null;
    }
    public static DeliveryGuy getDeliveryGuyByUserName(String username) {
        for (DeliveryGuy deliveryGuy : deliveryGuys) {
            if (deliveryGuy.getUsername().equals(username)) {
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
        return deliveryGuys;
    }
    public static Customer findCustomer(String username, String password) {
        for (Customer c : customers) {
            if (c.getUsername().equals(username) && c.checkPassword(password)) {
                return c;
            }
        }
        return null;
    }

    public static Chef findChef(String username, String password) {
        for (Chef c : chefs) {
            if (c.getUsername().equals(username) && c.checkPassword(password)) {
                return c;
            }
        }
        return null;
    }

    public static DeliveryGuy findDeliveryGuy(String username, String password) {
        for (DeliveryGuy d : deliveryGuys) {
            if (d.getUsername().equals(username) && d.checkPassword(password)) {
                return d;
            }
        }
        return null;
    }

}
