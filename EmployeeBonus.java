import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the employee's salary: ");
        double salary = sc.nextDouble();
        
        System.out.print("Enter the employee's years of service: ");
        int yearsOfService = sc.nextInt();
        
        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("The bonus amount is: " + bonus);
        } else {
            System.out.println("No bonus as year of service is less than 5.");
        }
    }
}
