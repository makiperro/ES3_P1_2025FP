package domain.order;

import domain.payment.PaymentTemplate;

import java.time.LocalDateTime;

public interface OrderState {
    void confirmOrderAndPay(PaymentTemplate payment);
    double getTotal();
    LocalDateTime getPaymentStartDate();
    LocalDateTime getPaymentEndDate();
}
