public class CreditCardPayment implements PaymentMethodStrategy{
    @Override
    public void pay(String paymentType) {
        System.out.println("Pagando via Cartão de Crédito...");
    }
}
