package service;

import model.Order;
import notification.Notifier;
import payment.PaymentMethod;
import payment.PaymentMethodStrategy;
import repository.OrderRepository;
import service.PricingService;

public class CheckoutService {

    private final OrderRepository database;
    private final Notifier emailSender;

    public CheckoutService(OrderRepository database, Notifier emailSender) {
        this.database = database;
        this.emailSender = emailSender;
    }

    public double checkout(Order order, PaymentMethodStrategy paymentStrategy) {
        System.out.println("[Checkout] iniciando pedido " + order.getId());

        PricingService pricingService = new PricingService(order);
        double total = pricingService.calculateTotal();

        PaymentMethod paymentMethod = new PaymentMethod(paymentStrategy);
        paymentMethod.payment();

        database.save(order);

        emailSender.send(order.getCustomer().getEmail(), "Pedido total: " + total);

        return total;
    }
}
