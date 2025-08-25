package payment;

public class CreditCardPayment implements PaymentMethodStrategy {
    @Override
    public void pay() {
        System.out.println("Pagando via Cartão de Crédito...");
    }
}
