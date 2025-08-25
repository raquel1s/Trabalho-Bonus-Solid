public class PaymentMethod {

    PaymentMethodStrategy paymentMethod;

    public PaymentMethod(PaymentMethodStrategy paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    void payment(String paymentType){
        paymentMethod.pay(paymentType);
    }
}
