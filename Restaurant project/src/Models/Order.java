package Models;

public class Order {
    private static int idCounter = 1;
    private int id;
    private Dish dish;
    private int quantity;
    private Customer cutomer;
    private OrderStatus status;

    public Order(Dish dish, int quantity, Customer cutomer){
        this.id=idCounter++;
        this.dish=dish;
        this.quantity=quantity;
        this.cutomer=cutomer;
        this.status=OrderStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public Dish getDish() {
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public Customer getCustomer() {
        return cutomer;
    }

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
