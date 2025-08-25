public class CheckoutService {

    private final Database database;
    private final EmailSender emailSender;

    public CheckoutService(Database database, EmailSender emailSender) {
        this.database = database;
        this.emailSender = emailSender;
    }

    public double checkout(Order order, PaymentMethodStrategy paymentStrategy) {
        System.out.println("[Checkout] iniciando pedido " + order.getId());

        PricingService pricingService = new PricingService(order);
        double total = pricingService.calculateTotal();

        PaymentMethod paymentMethod = new PaymentMethod(paymentStrategy);
        paymentMethod.payment();

        database.processOrder(order);

        emailSender.sendEmail(order.getCustomer().getEmail(), "Pedido total: " + total);

        return total;
    }
}
