import java.util.*;

public class ShoppingCart {
    private final Map<String, Double> productPrices = new HashMap<>();
    private final Map<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price, int quantity) {
        productPrices.put(product, price);
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(String product) {
        cart.remove(product);
        productPrices.remove(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public void displayCart() {
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue() + " @ " + productPrices.get(entry.getKey()));
        }
    }

    public void displaySortedByPrice() {
        TreeMap<Double, String> sorted = new TreeMap<>();
        for (String product : cart.keySet()) {
            sorted.put(productPrices.get(product), product);
        }
        for (Map.Entry<Double, String> entry : sorted.entrySet()) {
            System.out.println(entry.getValue() + " @ " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.2, 5);
        cart.addProduct("Banana", 0.8, 3);
        cart.addProduct("Orange", 1.5, 2);
        cart.displayCart();
        System.out.println("Total: " + cart.getTotalPrice());
        System.out.println("Sorted by Price:");
        cart.displaySortedByPrice();
    }
}
