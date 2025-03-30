package domain.order;

import domain.payment.PaymentTemplate;

import java.time.LocalDateTime;

public class ConfirmedOrder implements OrderState {


    private final double totalOrder;
    private final LocalDateTime confirmationDate;
    private final PaymentTemplate payment;
    private final Order order;

    public ConfirmedOrder(Order order, PaymentTemplate payment) {
        this.totalOrder = order.calculateTotalProducts();
        this.order = order;
        this.confirmationDate = LocalDateTime.now();
        this.payment = payment;
        this.payment.processPayment(); // Plantilla
    }

    @Override
    public void confirmOrderAndPay(PaymentTemplate payment) {
        System.out.println("La comanda ja ha estat confirmada.");
    }

    @Override
    public double getTotal() {
        return totalOrder;
    }

    public LocalDateTime getDate() {
        return confirmationDate;
    }

    @Override
    public LocalDateTime getPaymentStartDate() {
        return payment.getStartDate();
    }

    @Override
    public LocalDateTime getPaymentEndDate() {
        return payment.getEndDate();
    }
}
