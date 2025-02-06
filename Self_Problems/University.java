package Self_Problems;

import java.util.ArrayList;
import java.util.List;

class University {
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University() {
        students = new ArrayList<>();
        professors = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayUniversityData() {
        System.out.println("\nUniversity Courses and Enrollments:");
        for (Course course : courses) {
            System.out.println("Course: " + course.getName());
            System.out.println("Professor: " + (course.getProfessor() != null ? course.getProfessor().getName() : "Not Assigned"));
            System.out.println("Enrolled Students:");
            for (Student student : course.getStudents()) {
                System.out.println("- " + student.getName());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create University
        University university = new University();

        // Create Students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Create Professors
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        // Create Courses
        Course course1 = new Course("Computer Science");
        Course course2 = new Course("Mathematics");

        // Assign Professors to Courses
        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);

        // Students enroll in courses
        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course1);

        // Add Students, Professors, and Courses to University
        university.addStudent(student1);
        university.addStudent(student2);
        university.addProfessor(professor1);
        university.addProfessor(professor2);
        university.addCourse(course1);
        university.addCourse(course2);

        // Display University Data
        university.displayUniversityData();
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(name + " has enrolled in " + course.getName());
    }

    public List<Course> getCourses() {
        return courses;
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String name;
    private Professor professor;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.getName() + " is assigned to teach " + name);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}

