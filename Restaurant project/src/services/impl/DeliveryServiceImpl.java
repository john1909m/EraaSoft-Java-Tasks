package services.impl;

import Models.DeliveryGuy;
import Models.Order;
import Models.OrderStatus;
import data.OrderData;
import services.interfaces.DeliveryService;

import java.util.List;

public class DeliveryServiceImpl implements DeliveryService {
    private DeliveryGuy deliveryGuy;

    public DeliveryServiceImpl(DeliveryGuy deliveryGuy) {
        this.deliveryGuy = deliveryGuy;
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
                    " | Dish: " + order.getDish().getName() +
                    " | Qty: " + order.getQuantity() +
                    " | Customer: " + order.getCustomer().getUsername());
        }
        System.out.println("-----------------------------------");
    }

    @Override
    public void updateOrderStatus(String orderId, OrderStatus status) {

    }

    @Override
    public void updateOrderStatus(int orderId, OrderStatus status){
        Order order=OrderData.getOrderById(orderId);
        if(order==null && order.getStatus()==OrderStatus.READY_FOR_DELIVERY){
            order.setStatus(status);
            System.out.println("Order #" + orderId + " marked as " + status);
        }
        else{
            System.out.println("Order not found or not ready for delivery.");
        }
    }
}
