package Level1PracticeQuestions;
public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double rentalPricePerDay;

    // default price
    public static final double DEFAULT_RENTAL_PRICE = 50.0;

    // Constructor to initialize car rental details
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.rentalPricePerDay = DEFAULT_RENTAL_PRICE; 
    }

    // Constructor to initialize car rental details with a custom rental price
    public CarRental(String customerName, String carModel, int rentalDays, double rentalPricePerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public double calculateTotalCost() {
        return rentalDays * rentalPricePerDay;
    }

    public void displayRentalInfo() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Rental Price per Day: $" + rentalPricePerDay);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        // Car rental with default price
        CarRental c1 = new CarRental("Priyanshi", "Toyota Corolla", 5);
        // Car rental with custom price
        CarRental c2 = new CarRental("Priyanshi", "Toyota Corolla", 3, 60.0);

         // Display rental info
         System.out.println("Rental 1 Info:");
         c1.displayRentalInfo();
         
         System.out.println("\nRental 2 Info:");
         c2.displayRentalInfo();

    }
    

}
