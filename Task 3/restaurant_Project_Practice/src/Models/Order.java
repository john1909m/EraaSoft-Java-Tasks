package Models;

public class Order {
    private Dish dish;
    private int id;
    private int quantity;
    private Customer customer;
    private OrderStatus orderStatus;
    private static int idCounter=1;
    public Order(Dish dish, int quantity, Customer customer) {
        id=idCounter++;
        this.dish = dish;
        this.quantity = quantity;
        this.customer = customer;
        this.orderStatus = OrderStatus.PENDING;
    }

    public Dish getDish() {
        return dish;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
