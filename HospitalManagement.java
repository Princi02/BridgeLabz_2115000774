import java.util.ArrayList;
import java.util.List;

// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private List<String> medicalRecords;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getPatientDetails() + ":");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getPatientDetails() + ":");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
}

// Main class to test functionality
public class HospitalManagement {
    public static void main(String[] args) {
        InPatient inpatient = new InPatient(101, "Alice", 30, 5, 2000);
        OutPatient outpatient = new OutPatient(102, "Bob", 25, 500);

        inpatient.addRecord("Admitted for surgery");
        inpatient.addRecord("Post-surgery observation");
        outpatient.addRecord("General check-up");
        
        System.out.println(inpatient.getPatientDetails() + ", Bill: Rs. " + inpatient.calculateBill());
        inpatient.viewRecords();
        
        System.out.println(outpatient.getPatientDetails() + ", Bill: Rs. " + outpatient.calculateBill());
        outpatient.viewRecords();
    }
}
