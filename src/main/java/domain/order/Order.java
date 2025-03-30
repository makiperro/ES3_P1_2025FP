package domain.order;

import domain.payment.PaymentTemplate;
import domain.product.Product;
import domain.store.Store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final long id;
    private final List<Product> products;
    private OrderState state;

    public Order() {
        this.id = Store.getInstance().nextAvailableOrderNumber();
        this.products = new ArrayList<>();
        this.state = new PendingOrder(this); // Estat inicial
    }

    public long getId() {
        return id;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public List<String> getProductNames() {
        return products.stream().map(Product::getName).collect(Collectors.toList());
    }

    public double getTotal() {
        return state.getTotal();
    }

    public double getTotalWithoutDiscount() {
        return products.stream().mapToDouble(Product::getStandardPrice).sum();
    }

    public double calculateTotalProducts() {
        return products.stream().mapToDouble(Product::getDiscountedPrice).sum();
    }

    public void confirmOrderAndPay(PaymentTemplate payment) {
        state.confirmOrderAndPay(payment);
    }

    public LocalDateTime getPaymentStartDate() {
        return state.getPaymentStartDate();
    }

    public LocalDateTime getPaymentEndDate() {
        return state.getPaymentEndDate();
    }

    // Permet que els estats canviïn l'estat de la comanda
    protected void setState(OrderState newState) {
        this.state = newState;
    }

    protected List<Product> getProducts() {
        return products;
    }
}
