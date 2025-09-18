import Data.UserData;
import Models.Chef;
import Models.Customer;
import Models.DeliveryGuy;
import Models.OrderStatus;
import Services.impls.ChefServiceImpl;
import Services.impls.CustomerServiceImpl;
import Services.impls.DeliveryServiceImpl;
import Services.interfaces.DeliveryService;

import java.util.Scanner;


public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedInitialData();
        System.out.println("----WELCOME TO OUR RESTAURANT----");
        while (true) {
            System.out.println("Please Choose Your Choice");
            System.out.println("(1). Customer account");
            System.out.println("(2). Chef Account");
            System.out.println("(3). Delivery Guy Account");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:{
                    handleCustomer(sc);
                    break;
                }
                case 2:{
                    System.out.println("Please Enter Your username: ");
                    String username = sc.next();
                    System.out.println("Please Enter Your password: ");
                    String password = sc.next();
                    chefLogin(username,password);
                    break;
                }
                case 3:{
                    System.out.println("Please Enter Your username: ");
                    String username = sc.next();
                    System.out.println("Please Enter Your password: ");
                    String password = sc.next();
                    deliveryLogin(username,password);
                    break;
                }
                default:{
                    System.out.println("Wrong Choice");
                    break;
                }
            }
        }

    }
    private static void handleCustomer(Scanner sc) {
        CustomerServiceImpl customerService=new CustomerServiceImpl();
        System.out.println("(1)Register    ||    (2)Login");
        int choice2 = sc.nextInt();
        switch (choice2) {
            case 1:{
                System.out.println("--------------Register---------------");
                System.out.println("Please Enter Your username");
                String username = sc.next();
                System.out.println("Please Enter Your password");
                String password = sc.next();
                customerService.register(username, password);
                System.out.println("You have been registered successfully");
                System.out.println("----------------------------------------------");
            }
            case 2:{
                System.out.println("---------------Login---------------");
                System.out.println("Please Enter Your username");
                String username = sc.next();
                System.out.println("Please Enter Your password");
                String password = sc.next();
                if(customerService.login(username, password)){
                    Customer customer = UserData.findCustomer(username, password);
                    System.out.println("Logged in Successfully");
                    System.out.println("------------------------------------------");
                    System.out.println("Welcome "+username);
                    System.out.println("----------------");
                    CustomerServiceImpl service = new CustomerServiceImpl(customer);
                    while (true) {
                        System.out.println("""
                            \n--- Customer Menu ---
                            1. View Menu
                            2. Make Order
                            3. My Orders
                            0. Logout
                        """);
                        int choice = sc.nextInt();
                        sc.nextLine();
                        switch (choice) {
                            case 1:{
                                service.viewMenu();
                                break;
                            }
                            case 2:{
                                System.out.print("Dish name: ");
                                String dishName = sc.next();
                                System.out.print("Quantity: ");
                                int quantity = sc.nextInt();

                                service.makeOrder(dishName, quantity);
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
                                System.out.println("Invalid choice");
                                break;
                            }
                        }
                    }
                }
                else{
                    System.out.println("Wrong Password or username");
                    break;
                }
            }
        }
    }


    public static void chefLogin(String username, String password) {
        Chef chef = UserData.findChef(username, password);
        if (chef == null) {
            System.out.println("Invalid username or password");
            return;
        }
        System.out.println("Welcome "+username);

        ChefServiceImpl service = new ChefServiceImpl(chef);
        while (true) {
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
            switch (choice) {
                case 1:{
                    service.viewOrders();
                    break;
                }
                case 2:{
                    System.out.print("Dish name: ");
                    String dishName = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    service.addDish(dishName, price);
                    break;

                }
                case 3:{
                    System.out.print("Dish oldName: ");
                    String dishName = sc.nextLine();
                    System.out.print("Dish newName: ");
                    String newName = sc.nextLine();
                    System.out.print("Dish newPrice: ");
                    double newPrice = sc.nextDouble();
                    service.editDish(dishName, newName, newPrice);
                    break;

                }
                case 4:{
                    System.out.print("Dish ID: ");
                    int dishID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Status : (1)PENDING   |   (2)READY_FOR_DELIVERY   |   (3)DELIVERED   : ");
                    int status = sc.nextInt();
                    switch (status) {
                        case 1:{
                            service.updateOrderStatus(dishID,OrderStatus.PENDING);
                            System.out.println("Order Status has been updated");
                            break;
                        }
                        case 2:{
                            service.updateOrderStatus(dishID,OrderStatus.READY_FOR_DELIVERY);
                            System.out.println("Order Status has been updated");
                            break;
                        }
                        case 3:{
                            service.updateOrderStatus(dishID,OrderStatus.DELIVERED);
                            System.out.println("Order Status has been updated");
                            break;
                        }
                        default:{
                            System.out.println("Invalid choice");
                            break;
                        }
                    }

                }
                case 0:{

                    return;
                }
                default:{
                    System.out.println("Invalid choice");
                }
            }
        }

    }

    public static void deliveryLogin(String username, String password) {
        DeliveryGuy guy= UserData.findDeliveryGuy(username, password);
        if (guy == null) {
            System.out.println("Invalid username or password");
        }
        System.out.println("Welcome "+username);

        DeliveryService service = new DeliveryServiceImpl(guy);
        while (true) {
            System.out.println("""
                \n--- Delivery Menu ---
                1. View Orders
                2. Mark Order as Delivered
                0. Logout
            """);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:{
                    service.viewOrder();
                    break;
                }
                case 2:{
                    System.out.print("Dish Id: ");
                    int dishID = sc.nextInt();
                    sc.nextLine();
                    service.updateOrderStatus(dishID,OrderStatus.DELIVERED);
                    System.out.println("Order Status has been updated to Delivered");
                    break;
                }
                case 0:{
                    return;
                }
                default:{
                    System.out.println("Invalid choice");
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