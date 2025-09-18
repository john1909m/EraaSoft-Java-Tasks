package Services.interfaces;

import Models.OrderStatus;

public interface ChefService {
    public void addDish(String dishName,double price);
    public void editDish(String name, String newName, double newPrice);
    public void viewOrders();

    void updateOrderStatus(int orderId, OrderStatus status);
}
