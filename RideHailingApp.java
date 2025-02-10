import java.util.ArrayList;
import java.util.List;

// Abstract class Vehicle
abstract class Vehicle {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Car class
class Car extends Vehicle implements GPS {
    private String location;

    public Car(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 10;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 5;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 7;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Main class to test functionality
public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle car = new Car(201, "John", 10);
        Vehicle bike = new Bike(202, "Mike", 5);
        Vehicle auto = new Auto(203, "Raj", 7);

        System.out.println(car.getVehicleDetails() + ", Fare for 15km: Rs. " + car.calculateFare(15));
        System.out.println(bike.getVehicleDetails() + ", Fare for 15km: Rs. " + bike.calculateFare(15));
        System.out.println(auto.getVehicleDetails() + ", Fare for 15km: Rs. " + auto.calculateFare(15));
    }
}
