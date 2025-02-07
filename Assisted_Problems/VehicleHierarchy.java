package Assisted_Problems;

class Vehicle{
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType){
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo(){
        System.out.println("Vehicle details : ");
        System.out.println("max speed : " + maxSpeed);
        System.out.println("fuel type : " + fuelType);
    }
}


class Car extends Vehicle{
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("seat capicity in car : " + seatCapacity);
    }
}

class Truck extends Vehicle{
    int tires;

    Truck(int maxSpeed, String fuelType, int tires){
        super(maxSpeed, fuelType);
        this.tires = tires;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Tires in truck : " + tires);
    }

}


class Motorcycle extends Vehicle{
    double price;

    Motorcycle(int maxSpeed, String fuelType, double price){
        super(maxSpeed, fuelType);
        this.price = price;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Price of bike : " + price);
    }

}

public class VehicleHierarchy {
    public static void main(String[] args) {
        Vehicle car = new Car(200, "Petrol", 5);
        Vehicle truck = new Truck(120, "Diesel", 18);
        Vehicle motorcycle = new Motorcycle(180, "Electric", 15000);

        Vehicle[] vehicles = { car, truck, motorcycle };

        System.out.println("\nVehicle Information : \n");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
