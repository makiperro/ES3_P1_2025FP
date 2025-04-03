package presentation;


import domain.order.Order;
import domain.payment.PaymentFactory;
import domain.payment.PaymentMethod;
import domain.payment.PaymentTemplate;
import domain.product.FixedDiscount;
import domain.product.NoDiscount;
import domain.product.PercentageDiscount;
import domain.product.Product;
import domain.store.Store;
import java.util.LinkedList;
import java.util.List;


public class StartSimulation {

    public static void main (String [] args) {

        Store store = Store.getInstance();; //TODO: Create new store

        System.out.println("Welcome to " + store.getName() + " at " + store.getAddress());
        System.out.println("*******************");


        List<Product> productList = addProducts();
        show(productList);
        Order o = createOrder(productList);
        System.out.println("Pending order info:");
        System.out.println("--------");
        showOrder(o);
        System.out.println("-----------------------------------------");
        System.out.println("Order payment:");
        System.out.println("--------");
        //TODO: You can use these lines below to create different payment methods
        PaymentMethod paymentMethod1 = PaymentMethod.CreditCard;
        PaymentMethod paymentMethod2 = PaymentMethod.Bizum;
        PaymentMethod paymentMethod3 = PaymentMethod.PayPal;


        //TODO: Complete to create Payment
        PaymentTemplate pay = null;

        pay = PaymentFactory.createPayment(paymentMethod1);


        o.confirmOrderAndPay(pay);
        System.out.println("Completed order info:");
        System.out.println("--------");
        showCompletedOrder(o);
        System.out.println("-----------------------------------------");
    }



    private static List<Product> addProducts() {
        List<Product> prodList = new LinkedList<>();

        /*TODO: Create 10 different products with different discount types and add them to prodList*/


        prodList.add(new Product("Product1", 110121230, "deportes", new NoDiscount()));
        prodList.add(new Product("Product2", 20, "moda", new FixedDiscount(50)));
        prodList.add(new Product("Product3", 30, "moto",  new PercentageDiscount(10)));
        prodList.add(new Product("Product4", 40, "coches",  new NoDiscount()));
        prodList.add(new Product("Product5", 50, "lanchas de agua", new FixedDiscount(50)));
        prodList.add(new Product("Product6", 60, "musica", new PercentageDiscount(10)));
        prodList.add(new Product("Product7", 70, "electrodomesticos", new PercentageDiscount(10)));
        prodList.add(new Product("Product8", 80, "videojuegos", new FixedDiscount(50)));
        prodList.add(new Product("Product9", 90, "cine",  new NoDiscount()));
        prodList.add(new Product("Product10", 100, "fotografia", new PercentageDiscount(10)));

        /*TODO: Change the discount type of one of those created products*/

        prodList.getFirst().setDiscountStrategy(new PercentageDiscount(50));
        return prodList;
    }

    private static void show(List<Product> prodList){
        //System.out.println();
        System.out.println("Our store offers the following products:");
        for(Product p: prodList){
            show(p);
        }
        System.out.println("-----------------------------------------");

    }

    private static void show(Product p){
        System.out.println("Name:" + p.getName());
        System.out.println("Category:" + p.getCategory());
        System.out.println("Price:" + p.getStandardPrice());
        if (p.getStandardPrice() != p.getDiscountedPrice()) {
            System.out.println("Discounted Price: " + p.getDiscountedPrice());
        }
        System.out.println("******");
    }

    private static Order createOrder(List<Product> prodList) {
        /*TODO: Create a new pending order and add three different products from prodList*/
        Order o = new Order();
        o.addProduct(prodList.get(0));
        o.addProduct(prodList.get(1));
        o.addProduct(prodList.get(2));

        //TODO: Complete
        return o;
    }

    private static void showOrder(Order o) {
        System.out.println("Order ID: #" + o.getId());
        System.out.println("Total price w/discount: " + o.getTotal());
        System.out.println("Total price w/o discount: " + o.getTotalWithoutDiscount());
    }

    private static void showCompletedOrder(Order o) {
        showOrder(o);
        System.out.println("Start date and time: " + o.getPaymentStartDate());
        System.out.println("End date and time: " + o.getPaymentEndDate());
        System.out.println("Congratulations for buying the following products: ");
        System.out.println(o.getProductNames());
    }
}
