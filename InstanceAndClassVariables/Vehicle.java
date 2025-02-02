package InstanceAndClassVariables;
public class Vehicle {
    
    // instance variables
    String ownerName;
    String vehicleType;

    // class variable for default registration fee
    static double registrationFee = 100.0;

    public Vehicle(String ownerName, String vehicleType){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    

    // instance method to display details of vehicle and owner
    public void displayVehicleDetails(){
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);

    }

    // class method to update registration fee
    public static void updateRegistrationFee(double newFee){
        registrationFee = newFee;
        System.out.println("Updated Registration Fee : $" + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Priyanshi", "car");
        Vehicle v2 = new Vehicle("Aman", "Bike");

        // Displaying vehicle details
        System.out.println("\nVehicle Details:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
        System.out.println();
         
        // Updating the registration fee
        updateRegistrationFee(150.0);
         
        // Displaying vehicle details after updating the registration fee
        System.out.println("\nAfter updating the registration fee:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
