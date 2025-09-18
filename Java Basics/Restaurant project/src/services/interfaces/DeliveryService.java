package services.interfaces;

import Models.OrderStatus;

public interface DeliveryService {
    public void viewOrder();
    public void updateOrderStatus(String orderId, OrderStatus status);

    void updateOrderStatus(int orderId, OrderStatus status);
}
