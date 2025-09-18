package Model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Order> orders;
    public Customer(String username, String password) {
        super(username, password);
        this.orders = new ArrayList<>();
    }
}
