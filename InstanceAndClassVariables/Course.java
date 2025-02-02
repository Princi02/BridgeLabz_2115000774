package InstanceAndClassVariables;
public class Course {
    static String instituteName = "Nector Foundation";

    String courseName;
    int duration;
    double fee;

    public Course(String courseName, int duration, double fee){
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails(){
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName){
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        // Updating the institute name for all courses
        Course.updateInstituteName("Resonance");

        // Creating courses
        Course course1 = new Course("Java Programming", 3, 500);
        Course course2 = new Course("Data Science", 6, 800);

        // Displaying course details
        course1.displayCourseDetails();
        System.out.println(); // Adding space between outputs
        course2.displayCourseDetails();

        // Updating the institute name
        Course.updateInstituteName("Allen");

        System.out.println("\nAfter updating the institute name:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }

}
