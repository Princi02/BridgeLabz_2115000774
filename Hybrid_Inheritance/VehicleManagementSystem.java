package Hybrid_Inheritance;

class Vehicle{
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed){
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo(){
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}


interface Refuelable{
    void refuel();
}

class ElectricVehicle extends Vehicle{
    protected int batteryCapacity;
    
    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity){
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging. Battery Capacity: " + batteryCapacity + " kWh");
    }
}


class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel Capacity: " + fuelCapacity + " liters");
    }
}


public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200, 75);
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 250, 60);
        
        ev.displayInfo();
        ev.charge();
        
        System.out.println();
        
        pv.displayInfo();
        pv.refuel();
    }
}
