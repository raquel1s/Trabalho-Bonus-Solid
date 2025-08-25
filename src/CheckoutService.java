public class CheckoutService {
    public double checkout(Order order, PaymentMethodStrategy paymentStrategy) {
        System.out.println("[Checkout] iniciando pedido " + order.getId());

        PricingService pricingService = new PricingService(order);
        double total = pricingService.calculateTotal();

        PaymentMethod paymentMethod = new PaymentMethod(paymentStrategy);
        paymentMethod.payment();

        // 4) Persistência acoplada (quebra DIP)
        Database

        // 5) Notificação acoplada
        EmailSender.send(order.getCustomer().getEmail(), "Pedido aprovado: R$" + total);

        return total;
    }
}
