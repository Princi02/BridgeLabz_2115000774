package AccessModifiers;

class Employee{
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }
}

class Manager extends Employee {

    // Constructor to initialize Manager details
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary()); 
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Manager manager = new Manager(101, "Sales", 75000.00);

        manager.displayManagerDetails();

        manager.setSalary(80000.00);
        System.out.println("\nAfter salary modification:");
        manager.displayManagerDetails();
    }
}
