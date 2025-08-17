import Models.Chef;
import Models.Customer;
import Models.DeliveryGuy;
import Models.OrderStatus;
import Models.*;
import services.impl.*;
import data.*;
import services.interfaces.CustomerService;

import java.util.Currency;
import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        seedInitialData();
        System.out.println("📦 Welcome to Restaurant Management System");
     while (true) {
         System.out.print("Login as (1) Customer (2) Chef (3) DeliveryGuy: ");
         int choice = sc.nextInt();
         sc.nextLine();
         System.out.print("Enter username: ");
         String username = sc.nextLine();
         System.out.print("Enter password: ");
         String password = sc.nextLine();
         switch (choice){
             case 1:{
                 customerLogin(username,password);
                 break;
             }
             case 2:{
                 chefLogin(username,password);
                 break;
             }
             case 3:{
                 DeliveryGuyLogin(username,password);
                 break;
             }

             default:{
                 System.out.println("Invalid choice.");
                 break;
             }

         }

     }

    }

    private static void customerLogin(String username, String password){
        Customer customer=UserData.findCustomer(username, password);
        if(customer==null){
            System.out.println("Customer not found.");
            return;
        }
        CustomerServiceImpl service=new CustomerServiceImpl(customer);

        while (true){
            System.out.println("""
                \n--- Customer Menu ---
                1. View Menu
                2. Make Order
                3. My Orders
                0. Logout
            """);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:{
                    service.viewMenu();
                    break;

                }
                case 2:{
                    System.out.println("Dish name: ");
                    String name = sc.nextLine();
                    System.out.println("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    service.makeOrder(name, quantity);
                    break;

                }
                case 3:{
                    customer.getOrders();
                    break;

                }
                case 0:{
                    return;



                }
                default:{
                    System.out.println("Invalid choice.");
                    break;

                }
            }
        }
    }

    private static void chefLogin(String username, String password){
        Chef chef=UserData.findChef(username, password);
        if(chef==null){
            System.out.println("Chef not found.");
            return;
        }

        ChefServiceImpl service=new ChefServiceImpl();
        while (true){
            System.out.println("""
                \n--- Chef Menu ---
                1. View Orders
                2. Add Dish
                3. Edit Dish
                4. Update Order Status
                0. Logout
            """);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:{
                    service.viewOrder();
                    break;
                }
                case 2:{
                    System.out.println("Dish name: ");
                    String name = sc.nextLine();
                    System.out.println("Price: ");
                    double price = sc.nextInt();
                    sc.nextLine();
                    service.addDish(name, price);
                    break;
                }
                case 3:{
                    System.out.println("Dish oldName: ");
                    String oldName = sc.nextLine();
                    System.out.println("Dish newName: ");
                    String newName = sc.nextLine();
                    System.out.println("Dish newPrice: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();
                    service.editDish(oldName, newName, newPrice);
                    break;
                }
                case 4:{
                    System.out.println("Order Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Order Status: ");
                    String status = sc.nextLine();
                    service.updateOrderStatus(id, OrderStatus.valueOf(status));
                    break;
                }
                case 0:{
                    return;
                }
                default:{
                    System.out.println("Invalid choice.");
                    break;
                }
            }
        }

    }

private static void DeliveryGuyLogin(String username, String password){
    DeliveryGuy deliveryGuy=UserData.findDeliveryGuy(username, password);
    if(deliveryGuy==null){
        System.out.println("DeliveryGuy not found.");
        return;
    }
    DeliveryServiceImpl service=new DeliveryServiceImpl(deliveryGuy);
    while (true){
        System.out.println("""
                \n--- Delivery Menu ---
                1. View Orders
                2. Mark Order as Delivered
                0. Logout
            """);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){

            case 1:{
                service.viewOrder();
                break;
            }
            case 2:{
                System.out.println("Order Id: ");
                int id = sc.nextInt();
                sc.nextLine();
                service.updateOrderStatus(id,OrderStatus.DELIVERED);

                break;
            }
            case 0:{
                return;

            }
            default:{
                System.out.println("Invalid choice.");
                break;


            }
        }
    }

}
    private static void seedInitialData() {

        UserData.addChef(new Chef("chef", "123"));
        UserData.addCustomer(new Customer("john", "111"));
        UserData.addDeliveryGuy(new DeliveryGuy("driver", "222"));
    }

}