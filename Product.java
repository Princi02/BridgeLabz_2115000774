public class Product {
    static double discount = 10.0; 
    final int productID;          
    String productName;
    double price;
    int quantity;

    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount; 
    }

    public void displayDetails() {
        if (this instanceof Product){
            System.out.println("Product Name: " + productName);
            System.out.println("Product ID: " + productID);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 75000.00, 2, 101);

        product1.displayDetails();
        
        System.out.println("\nUpdating Discount to 15%");
        Product.updateDiscount(15.0);

        product1.displayDetails();
    }
}
