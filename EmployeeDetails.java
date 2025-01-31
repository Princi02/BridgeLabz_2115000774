class Employee{
    String name;
    int id;
    int salary;
    Employee(String name, int id, int salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
        
    }

    public void details(){
        System.out.println("The name of the employee : " + name);
        System.out.println("The id of the employee : " + id);
        System.out.println("The salary of the employee : " + salary);
    }
}

public class EmployeeDetails{
    public static void main(String[] args) {
        Employee em = new Employee("Priyanshi", 2115000774, 50000);
        em.details();
    }
}

