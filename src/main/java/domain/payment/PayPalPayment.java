package domain.payment;

public class PayPalPayment extends PaymentTemplate {
    @Override
    protected void obtainPaymentData() {
        System.out.println("Paypal account information received");
    }

    @Override
    protected void validateData() {
        System.out.println("Validated customer data successfully");
    }

    @Override
    protected boolean performPayment() {
        System.out.println("Paypal payment made successfully");
        return true;
    }

    @Override
    protected void sendReceipt() {
        System.out.println("Receipt sent to customer");
    }
}
