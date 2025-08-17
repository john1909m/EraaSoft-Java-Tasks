package Services.impls;
import Data.OrderData;
import Data.UserData;
import Models.DeliveryGuy;
import Models.Order;
import Models.OrderStatus;
import Services.interfaces.DeliveryService;
import Services.interfaces.UserService;

import java.util.List;

public class DeliveryServiceImpl implements DeliveryService, UserService {
    private DeliveryGuy guy;

    public DeliveryServiceImpl(DeliveryGuy guy) {
        this.guy = guy;
    }
    @Override
    public boolean login(String username, String password) {
        for (DeliveryGuy g: UserData.getDeliveryGuys()) {
            if (g.getUsername().equals(username) && g.getPassword().equals(password)) {
                guy = g;
                System.out.println(username + " logged in successfully");
                return true;
            }
        }
        System.out.println(username + " log in FAILED");
        return false;

    }
    public DeliveryGuy getLoggedInDeliveryGuy() {
        return guy;
    }
    @Override
    public void viewOrder(){
        OrderData orderData = new OrderData();
        List<Order> readyOrders=orderData.getOrderByStatus(OrderStatus.READY_FOR_DELIVERY.name());
        if(readyOrders.isEmpty()){
            System.out.println("No orders found");
            return;
        }
        System.out.println("----Orders Ready For Delivery----");
        for (Order order : readyOrders) {
            System.out.println("ID: " + order.getId() +
                    " | Dish: " + order.getDish().getDishName() +
                    " | Qty: " + order.getQuantity() +
                    " | Customer: " + order.getCustomer().getUsername());
        }
        System.out.println("-----------------------------------");
    }
    @Override
    public void updateOrderStatus(int orderId, OrderStatus status){
        Order order=OrderData.getOrderById(orderId);
        if(order==null && order.getOrderStatus()==OrderStatus.READY_FOR_DELIVERY){
            order.setOrderStatus(status);
            System.out.println("Order #" + orderId + " marked as " + status);
        }
        else{
            System.out.println("Order not found or not ready for delivery.");
        }
    }
}
