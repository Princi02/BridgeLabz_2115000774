import java.util.ArrayList;
import java.util.List;

// Enum for product categories
enum BookCategory { FICTION, NON_FICTION, EDUCATIONAL }
enum ClothingCategory { MEN, WOMEN, KIDS }
enum GadgetCategory { MOBILE, LAPTOP, ACCESSORY }

// Generic Product class restricted to a category
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (Category: " + category + ", Price: $" + price + ")";
    }
}

// Marketplace Catalog
class Catalog {
    private List<Product<?>> products = new ArrayList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }

    // Generic method to apply a discount to any product
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied! New Price of " + product.getName() + ": $" + product.getPrice());
    }
}

// Main class to test the marketplace system
public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("The Great Gatsby", 15.99, BookCategory.FICTION);
        Product<ClothingCategory> shirt = new Product<>("Men's T-Shirt", 25.50, ClothingCategory.MEN);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 499.99, GadgetCategory.MOBILE);
        
        Catalog catalog = new Catalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);
        
        System.out.println("Product Catalog:");
        catalog.displayProducts();
        
        System.out.println("\nApplying discounts:");
        Catalog.applyDiscount(book, 10);
        Catalog.applyDiscount(phone, 5);
        
        System.out.println("\nUpdated Product Catalog:");
        catalog.displayProducts();
    }
}
