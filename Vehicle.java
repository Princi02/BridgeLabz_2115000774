public class Vehicle {
    static double registrationFee = 2000.00;
    final String registrationNumber;
    String ownerName;
    String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("\nUpdating Registration Fee to " + newFee + "\n");
    }

    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) { 
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee + "\n");
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Priyanhsi", "Car", "ABC123");
        Vehicle vehicle2 = new Vehicle("Neha", "Scooty", "XYZ456");

        vehicle1.displayRegistrationDetails();  
        vehicle2.displayRegistrationDetails(); 

        // Update registration fee using static method
        
        Vehicle.updateRegistrationFee(2500.0);

        vehicle1.displayRegistrationDetails();  
        vehicle2.displayRegistrationDetails();  
    }
}
