public class Student {
    static String universityName = "GLA University";
    static int totalStudents = 0;
    final int rollNumber;
    String name;
    String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total students enrolled in " + universityName + ": " + totalStudents + "\n");
    }

    public void displayDetails() {
        if (this instanceof Student){ 
            System.out.println("Student Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade + "\n");
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student){
            this.grade = newGrade;
            System.out.println("Grade of " + name + " updated to: " + newGrade +
            "\n");
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Priyanshi", 146, "A");
        Student student2 = new Student("Aman", 102, "B");

        Student.displayTotalStudents(); 

        student1.displayDetails(); 
        student2.displayDetails();

        student1.updateGrade("A+");
        student2.updateGrade("A");

        student1.displayDetails();
        student2.displayDetails();
    }
}
