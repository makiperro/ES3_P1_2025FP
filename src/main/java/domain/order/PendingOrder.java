package domain.order;

import domain.payment.PaymentTemplate;

import java.time.LocalDateTime;

public class PendingOrder implements OrderState {


    private final Order order;

    public PendingOrder(Order order) {
        this.order = order;
    }

    @Override
    public void confirmOrderAndPay(PaymentTemplate payment) {
        ConfirmedOrder confirmed = new ConfirmedOrder(order, payment);
        order.setState(confirmed);
    }

    @Override
    public double getTotal() {
        return order.calculateTotalProducts();
    }

    @Override
    public LocalDateTime getPaymentStartDate() {
        return null;
    }

    @Override
    public LocalDateTime getPaymentEndDate() {
        return null;
    }
}
