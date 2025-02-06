package Self_Problems;

import java.util.ArrayList;
import java.util.List;

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void displaySchool() {
        System.out.println("School: " + name);
        for (Student student : students) {
            student.displayStudentCourses();
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this); 
        } else {
            System.out.println(name + " is already enrolled in " + course.getName());
        }
    }

    
    public void displayStudentCourses() {
        System.out.println("   - Student: " + name);
        for (Course course : courses) {
            System.out.println("     - Enrolled in Course: " + course.getName());
        }
    }

    public String getName() {
        return name;
    }
}


class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void displayCourse() {
        System.out.println("   - Course: " + name);
        for (Student student : students) {
            System.out.println("     - Student: " + student.getName());
        }
    }

    public String getName() {
        return name;
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        
        // Create a school
        School school = new School("XYZ High School");

        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        Course history = new Course("History");

        // Create students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Student charlie = new Student("Charlie");

        // Enroll students in courses
        alice.enrollInCourse(math);
        alice.enrollInCourse(science);
        bob.enrollInCourse(science);
        charlie.enrollInCourse(history);
        charlie.enrollInCourse(math);

        // Add students to the school
        school.addStudent(alice);
        school.addStudent(bob);
        school.addStudent(charlie);

        // Display the school details
        school.displaySchool();
    }
}

