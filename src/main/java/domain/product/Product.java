package domain.product;

public class Product {
    private final String name;
    private final double standardPrice;
    private final String category;
    private DiscountStrategy discountStrategy;

    // Constructor sense descompte
    public Product(String name, double price, String category) {
        this.name = name;
        this.standardPrice = price;
        this.category = category;
        this.discountStrategy = new NoDiscount(); // per defecte
    }

    // Constructor amb descompte
    public Product(String name, double price, String category, DiscountStrategy discountStrategy) {
        this.name = name;
        this.standardPrice = price;
        this.category = category;
        this.discountStrategy = discountStrategy;
    }

    public String getName() {
        return name;
    }

    public double getStandardPrice() {
        return standardPrice;
    }

    public String getCategory() {
        return category;
    }

    public double getDiscountedPrice() {
        return discountStrategy.applyDiscount(standardPrice);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public DiscountStrategy getDiscountStrategy (){
        return this.discountStrategy;
    }
}

