public class CheckoutService {

    public double checkout(Order order, String paymentType) {
        // 1) Regra de negócio misturada com IO/log
        System.out.println("[Checkout] iniciando pedido " + order.getId());

        // 2) Cálculo do total + descontos fixos hardcoded
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        if (order.getCustomer().isStudent()) {
            total = total * 0.95; // desconto fixo p/ estudante
        }

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
