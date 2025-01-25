import java.util.Scanner;
public class EmployeeBonus{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;
        for(int i=0; i<10; i++){
            System.out.println("Enter salary for employee " + (i+1) + ":");
            while(true){
                try {
                    salary[i] = sc.nextDouble();
                    if(salary[i] <= 0) throw new Exception();
                    sc.nextLine();
                    break;
                } catch (Exception e){
                    System.out.println("Invalid input. Please enter a positive number for salary:");
                    sc.nextLine();
                }
            }

            System.out.println("Enter years of service for employee " + (i+1) + ":");
            while(true){
                try {
                    yearsOfService[i] = sc.nextDouble();
                    if(yearsOfService[i] <= 0) throw new Exception();
                    sc.nextLine();
                    break;
                } catch (Exception e){
                    System.out.println("Invalid input. Please enter a non-negative number for years of service:");
                    sc.nextLine();
                }
            }

        }

        for(int i=0; i<10; i++){
            if(yearsOfService[i] > 5){
                bonus[i] = salary[i] * 0.5;
            }
            else{
                bonus[i] = salary[i] * 0.2;
            }
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
    }
}