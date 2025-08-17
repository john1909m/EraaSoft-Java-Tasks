package services.interfaces;

public interface CustomerService {
    void viewMenu();

    public void viewOrder();
    public void makeOrder(String dishName, int quantity);
}
