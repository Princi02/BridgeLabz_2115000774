import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary; 
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}



interface Department {
    void assignDepartment(String department);

    String getDepartmentDetails();
}


class FullTimeEmployee extends Employee implements Department{
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary(); 
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}



class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int workHours) {
        super(employeeId, name, 0); 
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workHours;
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}




public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee fte = new FullTimeEmployee(101, "Alice", 50000);
        PartTimeEmployee pte = new PartTimeEmployee(102, "Bob", 200, 25);

        fte.assignDepartment("IT");
        pte.assignDepartment("HR");
        
        employees.add(fte);
        employees.add(pte);

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println(emp instanceof Department ? ((Department) emp).getDepartmentDetails() : "");
        }
    }
}
