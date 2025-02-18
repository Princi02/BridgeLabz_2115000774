import java.util.ArrayList;
import java.util.List;

// Abstract class representing different types of courses
abstract class CourseType {
    private String courseName;
    
    public CourseType(String courseName) {
        this.courseName = courseName;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + courseName;
    }
}

// Different course types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private T course;
    
    public Course(T course) {
        this.course = course;
    }
    
    public T getCourse() {
        return course;
    }
    
    @Override
    public String toString() {
        return course.toString();
    }
}

// University Course Management System
class University {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();
    
    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }
    
    public void displayCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

// Main class to test the implementation
public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>(new ExamCourse("Mathematics"));
        Course<AssignmentCourse> literature = new Course<>(new AssignmentCourse("English Literature"));
        Course<ResearchCourse> aiResearch = new Course<>(new ResearchCourse("AI & Machine Learning"));
        
        University university = new University();
        university.addCourse(math);
        university.addCourse(literature);
        university.addCourse(aiResearch);
        
        System.out.println("University Courses:");
        university.displayCourses();
    }
}
