import java.util.ArrayList;

public class Order {

    private int id;
    private ArrayList<OrderItem> items;
    private Customer customer;

    public Order(int id, Customer customer) {
        this.id = id;
        this.items = new ArrayList<>();
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }
}
