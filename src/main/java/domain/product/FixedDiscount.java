package domain.product;

public class FixedDiscount implements DiscountStrategy {
    private final double discountAmount;

    public FixedDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double price) {
        return Math.max(price - discountAmount, 0);
    }
}
