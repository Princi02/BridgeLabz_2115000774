package Self_Problems;

import java.util.*;

class University {
    private String name;
    private List<Department> departments = new ArrayList<>();

    public University(String name) {
         this.name = name; 
        }
    
    public void addDepartment(String deptName) { 
        departments.add(new Department(deptName, this)); 
    }
    
    public void removeUniversity() {
        departments.clear();
    }

    public List<Department> getDepartments() {
        return departments; 
    }
}

class Department {
    private String name;
    private University university;
    private List<Faculty> faculties = new ArrayList<>();

    public Department(String name, University university) {
        this.name = name;
        this.university = university;
    }

    public void addFaculty(Faculty faculty) { 
        faculties.add(faculty); 
    }
}


class Faculty {
    private String name;
    public Faculty(String name) { this.name = name; }
    public String getName() { return name; }
}

public class UniversitySystem {
    public static void main(String[] args) {
        University uni = new University("Tech University");
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical");

        Faculty f1 = new Faculty("Dr. Smith"), f2 = new Faculty("Prof. Alice");

        uni.getDepartments().get(0).addFaculty(f1);
        uni.getDepartments().get(0).addFaculty(f2);
        uni.getDepartments().get(1).addFaculty(f1);

        uni.removeUniversity();
        System.out.println("University deleted. Faculty members still exist: " + f1.getName() + ", " + f2.getName());
    }
}

