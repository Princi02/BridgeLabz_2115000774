package Assisted_Problems;

import java.util.ArrayList;
import java.util.List;

class Company{
    private String name;
    private List<Department> departments;

    public Company(String name){
        this.name = name;
        this.departments = new ArrayList<>();

    }

    public void addDepartment(String departmentName){
        Department existringDepartment = findDepartment(departmentName);
        if(existringDepartment == null){
            departments.add(new Department(departmentName));
        }
        else{
            System.out.println("Department already existed");
        }
    }

    public Department findDepartment(String name){
        for(Department department : departments){
            if(department.getName().equalsIgnoreCase(name)){
                return department;
            }
        }
        return null;
    }

    public void displayCompany() {
        System.out.println("Company: " + name);
        for (Department department : departments) {
            department.displayDepartment();
        }
    }

}





class Department{
    private String name;
    private List<Employee> employees;
    // private String companyName;

    public Department(String name){
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void addEmployee(String employee, String role){
        Employee existingEmployee = findEmployee(employee);
        if(existingEmployee == null){
            employees.add(new Employee(name, role));
        }else {
            System.out.println("Employee already exists in the department");
        }
    }

    public Employee findEmployee(String name){
        for(Employee employee : employees){
            if(employee.getName().equalsIgnoreCase(name)){
                return employee;
            }
        }
        return null;
    }

    public void displayDepartment() {
        System.out.println("- Department: " + name);
        for (Employee employee : employees) {
            employee.displayEmployee();
        }
    }
}





class Employee{
    private String name;
    private String role;

    public Employee(String name, String role){
        this.name = name;
        this.role = role;
    }


    public void displayEmployee() {
        System.out.println("   - Employee: " + name + ", Role: " + role);
    }

    public String getName(){
        return name;
    }
}



public class CompanyWork {
    public static void main(String[] args) {
        Company company = new Company("Capgemini");

        company.addDepartment("ManagementDepartment");
        company.addDepartment("TestingDepartment");
        // company.addDepartment("ManagementDepartment");


        Department management = company.findDepartment("ManagementDepartment");
        if (management != null) {
            management.addEmployee("Alice", "Manager");
            management.addEmployee("Bob", "Assistant Manager");
        }

        Department testing = company.findDepartment("TestingDepartment");
        if (testing != null) {
            testing.addEmployee("Charlie", "Test Engineer");
        }


        company.displayCompany();

    }
}

