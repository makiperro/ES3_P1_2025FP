package domain.product;

public class PercentageDiscount implements DiscountStrategy {
    private final double discountPercentage;

    public PercentageDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("El percentatge ha d'estar entre 0 i 100");
        }
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price * (1 - discountPercentage / 100);
    }
}
