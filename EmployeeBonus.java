import java.util.Random;

public class EmployeeBonus {

    public static double[][] determineSalaryAndYearsOfService() {
        Random rand = new Random();
        double[][] employeeData = new double[10][2]; // 2D Array to store salary and years of service

        for (int i = 0; i < 10; i++) {
            // Random 5-digit salary between 10000 and 99999
            double salary = 10000 + rand.nextInt(90000);
            // Random years of service between 1 and 20 years
            int yearsOfService = 1 + rand.nextInt(20);
            employeeData[i][0] = salary; // Store salary in column 0
            employeeData[i][1] = yearsOfService; // Store years of service in column 1
        }

        return employeeData;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] updatedData = new double[10][3]; // 2D Array to store old salary, bonus, and new salary

        for (int i = 0; i < 10; i++) {
            double oldSalary = employeeData[i][0];
            int yearsOfService = (int) employeeData[i][1];
            double bonus = 0;

            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05; // 5% bonus for service > 5 years
            } else {
                bonus = oldSalary * 0.02; // 2% bonus for service <= 5 years
            }

            double newSalary = oldSalary + bonus;

            updatedData[i][0] = oldSalary; // Store old salary
            updatedData[i][1] = bonus; // Store bonus
            updatedData[i][2] = newSalary; // Store new salary
        }

        return updatedData;
    }

    public static void calculateAndDisplayTotals(double[][] updatedData) {
        double sumOldSalary = 0;
        double sumNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Employee Bonus Details:");
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Employee", "Old Salary", "Bonus", "New Salary");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            double oldSalary = updatedData[i][0];
            double bonus = updatedData[i][1];
            double newSalary = updatedData[i][2];

            sumOldSalary += oldSalary;
            sumNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f\n", i + 1, oldSalary, bonus, newSalary);
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s %-10.2f %-10.2f %-10.2f\n", "Totals", sumOldSalary, totalBonus, sumNewSalary);
    }

    public static void main(String[] args) {
        double[][] employeeData = determineSalaryAndYearsOfService();
        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);
        calculateAndDisplayTotals(updatedData);
    }
}
