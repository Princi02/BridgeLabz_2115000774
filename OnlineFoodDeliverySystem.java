import java.util.*;

// Abstract Class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Discountable Interface
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// VegItem Class
class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        return getQuantity() * getPrice() * (1 - discount / 100);
    }

    @Override
    public void applyDiscount(double percentage) {
        this.discount = percentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount: " + discount + "%";
    }
}

// NonVegItem Class
class NonVegItem extends FoodItem implements Discountable {
    private double discount;
    private static final double NON_VEG_SURCHARGE = 20.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        return (getQuantity() * (getPrice() + NON_VEG_SURCHARGE)) * (1 - discount / 100);
    }

    @Override
    public void applyDiscount(double percentage) {
        this.discount = percentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount: " + discount + "%";
    }
}

// Main Class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        VegItem vegItem = new VegItem("Paneer Tikka", 150, 2);
        NonVegItem nonVegItem = new NonVegItem("Chicken Biryani", 250, 1);

        vegItem.applyDiscount(10);
        nonVegItem.applyDiscount(5);

        order.add(vegItem);
        order.add(nonVegItem);

        double totalOrderPrice = 0;
        for (FoodItem item : order) {
            System.out.println(item.getItemDetails());
            System.out.println("Total Price: " + item.calculateTotalPrice());
            if (item instanceof Discountable discountableItem) {
                System.out.println(discountableItem.getDiscountDetails());
            }
            totalOrderPrice += item.calculateTotalPrice();
            System.out.println("-----------------------------------");
        }

        System.out.println("Final Order Total: " + totalOrderPrice);
    }
}
