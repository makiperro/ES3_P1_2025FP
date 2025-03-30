package domain.payment;

public class PaymentFactory {

    // This method creates a new payment object based on the payment type

    public static PaymentTemplate createPayment(PaymentMethod paymentType) {
        return switch (paymentType) {
            case PaymentMethod.PayPal -> new PayPalPayment();
            case PaymentMethod.CreditCard -> new CreditCardPayment();
            case PaymentMethod.Bizum -> new BizumPayment();
            default->
                throw new IllegalArgumentException("Mètode de pagament no suportat");

        };
    }
}
