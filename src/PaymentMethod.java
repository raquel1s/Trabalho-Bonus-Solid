public class PaymentMethod {

    PaymentMethodStrategy paymentMethod;

    public PaymentMethod(PaymentMethodStrategy paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    void payment(){
        paymentMethod.pay();
    }
}
