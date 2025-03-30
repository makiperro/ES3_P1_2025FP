package domain.payment;

import java.time.LocalDateTime;

public abstract class PaymentTemplate {
    private final LocalDateTime start;
    private LocalDateTime end;

    public PaymentTemplate() {
        this.start = LocalDateTime.now();
    }

    public final void processPayment() {
        obtainPaymentData();
        validateData();
        performPayment();
        setEndDate();
        sendReceipt();
    }

    protected abstract void obtainPaymentData();
    protected abstract void validateData();
    protected abstract boolean performPayment();
    protected abstract void sendReceipt();

    private void setEndDate() {
        this.end = LocalDateTime.now();
    }

    public LocalDateTime getStartDate() {
        return start;
    }

    public LocalDateTime getEndDate() {
        return end;
    }
}
