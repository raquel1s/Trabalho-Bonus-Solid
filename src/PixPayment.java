public class PixPayment implements PaymentMethodStrategy{
    @Override
    public void pay(String paymentType) {
        System.out.println("Pagando via PIX...");
    }
}
