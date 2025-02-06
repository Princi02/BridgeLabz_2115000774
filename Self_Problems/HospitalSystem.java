package Self_Problems;

import java.util.ArrayList;
import java.util.List;

class Hospital {
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }
}

class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        System.out.println("Doctor " + name + " is consulting patient " + patient.getName() + ".");
    }

    public List<Patient> getPatients() {
        return patients;
    }
}

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void visitDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
        doctor.consult(this);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        // Create Hospital
        Hospital hospital = new Hospital();

        // Create Doctors
        Doctor doctor1 = new Doctor("Dr. Smith");
        Doctor doctor2 = new Doctor("Dr. Johnson");

        // Create Patients
        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");

        // Add Doctors and Patients to the hospital
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Patients visit Doctors
        patient1.visitDoctor(doctor1);
        patient1.visitDoctor(doctor2);
        patient2.visitDoctor(doctor1);

        // Display Doctors for each patient
        System.out.println("\nPatients visited by Dr. Smith:");
        for (Patient p : doctor1.getPatients()) {
            System.out.println(p.getName());
        }

        System.out.println("\nPatients visited by Dr. Johnson:");
        for (Patient p : doctor2.getPatients()) {
            System.out.println(p.getName());
        }
    }
}

