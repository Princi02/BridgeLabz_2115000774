public class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;
    final int patientID;
    String name;
    int age;
    String ailment;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total patients admitted to " + hospitalName + ": " + totalPatients 
        + "\n");
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Patient Name: " + name);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment + "\n");
        }
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient("Alice", 45, "Flu", 101);
        Patient patient2 = new Patient("Bob", 30, "Fracture", 102);

        getTotalPatients();

        patient1.displayDetails();
        patient2.displayDetails();
    }
}
