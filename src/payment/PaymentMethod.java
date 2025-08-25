package payment;

public class PaymentMethod {

    PaymentMethodStrategy paymentMethod;

    public PaymentMethod(PaymentMethodStrategy paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void payment(){
        paymentMethod.pay();
    }
}
