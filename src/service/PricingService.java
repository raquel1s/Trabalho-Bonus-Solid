package service;

import model.Order;
import model.OrderItem;

public class PricingService {
    private Order order;

    public PricingService(Order order) {
        this.order = order;
    }

    public double calculateTotal(){
        double total = 0;

        for (OrderItem item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }

        if (order.getCustomer().isStudent()) {
            total = total * 0.95;
        }

        return total;
    }
}
