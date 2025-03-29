package domain.payment;

public class PaymentFactory {

    // This method creates a new payment object based on the payment type

    public static PaymentTemplate createPayment(String paymentType) {
        return switch (paymentType) {
            case "PayPal" -> new PayPalPayment();
            case "CreditCard" -> new CreditCardPayment();
            case "Bizum" -> new BizumPayment();
            default -> null;
        };
    }
}
