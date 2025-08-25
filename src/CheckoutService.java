public class CheckoutService {
    public double checkout(Order order, String paymentType) {
        System.out.println("[Checkout] iniciando pedido " + order.getId());

        PricingService pricingService = new PricingService(order);
        double total = pricingService.calculateTotal();

        // 3) Seleção de pagamento por if/else (quebra OCP)
        
        if ("PIX".equals(paymentType)) {
            System.out.println("Pagando via PIX...");
        } else if ("CREDIT".equals(paymentType)) {
            System.out.println("Pagando via Cartão de Crédito...");
        } else {
            throw new RuntimeException("Método de pagamento não suportado");
        }

        // 4) Persistência acoplada (quebra DIP)
        Database.save(order.getId(), total);

        // 5) Notificação acoplada
        EmailSender.send(order.getCustomer().getEmail(), "Pedido aprovado: R$" + total);

        return total;
    }
}
