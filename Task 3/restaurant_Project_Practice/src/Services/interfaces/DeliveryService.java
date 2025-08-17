package Services.interfaces;

import Models.OrderStatus;

public interface DeliveryService {
    void viewOrder();
    public void updateOrderStatus(int orderId, OrderStatus status);


}
