package AccessModifiers;

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA){
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA(){
        return CGPA;
    }

    public void setCGPA(double CGPA){
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value. CGPA should be between 0.0 and 10.0.");
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// PostgraduateStudent class (Subclass)
class PostgraduateStudent extends Student {

    // Constructor to initialize PostgraduateStudent details
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    // Method to display Postgraduate student details
    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);  // Accessing protected member from superclass
        System.out.println("CGPA: " + getCGPA());  // Accessing CGPA via public getter method
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating Student object
        Student student = new Student(146, "Priyanshi", 8.5);
        student.displayStudentDetails();

        // Modifying CGPA using setter method
        student.setCGPA(9.2);
        System.out.println("\nAfter modifying CGPA:");
        student.displayStudentDetails();

        // Creating PostgraduateStudent object
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Bob", 9.8);
        pgStudent.displayPostgraduateDetails();
    }
}
