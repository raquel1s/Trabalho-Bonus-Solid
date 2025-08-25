package payment;

import payment.PaymentMethodStrategy;

public class PixPayment implements PaymentMethodStrategy {
    @Override
    public void pay() {
        System.out.println("Pagando via PIX...");
    }
}
