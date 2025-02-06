package Self_Problems;

import java.util.ArrayList;
import java.util.List;

class ECommercePlatform {
    private List<Customer> customers;
    private List<Order> orders;

    public ECommercePlatform() {
        customers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void displayCustomerOrders() {
        for (Customer customer : customers) {
            System.out.println("\nOrders placed by " + customer.getName() + ":");
            for (Order order : customer.getOrders()) {
                System.out.println("Order ID: " + order.getOrderId());
                for (Product p : order.getProducts()) {
                    System.out.println("- " + p.getName() + " ($" + p.getPrice() + ")");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create E-commerce Platform
        ECommercePlatform platform = new ECommercePlatform();

        // Create Customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Create Products
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Headphones", 199.99);
        Product product3 = new Product("Smartphone", 799.99);

        // Create Orders
        Order order1 = new Order("ORD1001");
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order("ORD1002");
        order2.addProduct(product2);
        order2.addProduct(product3);

        // Add Orders to Customers
        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        // Add Customers to Platform
        platform.addCustomer(customer1);
        platform.addCustomer(customer2);

        // Display orders placed by customers using the platform
        platform.displayCustomerOrders();
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}

class Order {
    private List<Product> products;
    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
        products = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

