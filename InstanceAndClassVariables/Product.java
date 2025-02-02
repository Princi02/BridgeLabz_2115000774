package InstanceAndClassVariables;
public class Product {
    String productName;
    double price;
    static int totalProducts;

    public Product(String productName, double price){
        this.productName = productName;
        this.price = price;
        Product.totalProducts+=1;
    }

    public void displayProductDetails(){
        System.out.println("The name of the product is : " + productName);
        System.out.println("The price of the product is : " + price);
    }
    
    public static void displayTotalProducts(){
        System.out.println("Total products are : " + totalProducts);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Shoes", 2000);
        Product p2 = new Product("Shoes", 5000);

        p1.displayProductDetails();
        // calling static method
        Product.displayTotalProducts();
    }

}
