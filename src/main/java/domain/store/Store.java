package domain.store;

public class Store {
    private static Store instance;

    private String name;
    private String address;
    private long totalOrders;

    // Constructor privat (Singleton)
    private Store() {
        this.name = "BotigaOnline"; // pots posar el nom que vulguis
        this.address = "https://botigaonline.cat"; // pots posar l'adreça que vulguis
        this.totalOrders = 0;
    }

    // Mètode per accedir a la instància única
    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    // Mètode per obtenir el següent número de comanda
    public long nextAvailableOrderNumber() {
        return totalOrders++;
    }
}
