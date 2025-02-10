import java.util.*;

// Abstract Class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public String getVehicleDetails() {
        return "Vehicle Number: " + vehicleNumber + ", Type: " + type;
    }
}

// Insurable Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car Class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.1;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy Number: [Protected]";
    }
}

// Bike Class
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy Number: [Protected]";
    }
}

// Truck Class
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate * 1.2; // Trucks have an extra surcharge
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy Number: [Protected]";
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR123", 500, "INS1001"));
        vehicles.add(new Bike("BIKE456", 200, "INS2002"));
        vehicles.add(new Truck("TRUCK789", 1000, "INS3003"));

        int rentalDays = 5;
        for (Vehicle v : vehicles) {
            System.out.println(v.getVehicleDetails());
            System.out.println("Rental Cost for " + rentalDays + " days: " + v.calculateRentalCost(rentalDays));
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println("Insurance Cost: " + ins.calculateInsurance());
                System.out.println(ins.getInsuranceDetails());
            }
            System.out.println("-----------------------------------");
        }
    }
}
