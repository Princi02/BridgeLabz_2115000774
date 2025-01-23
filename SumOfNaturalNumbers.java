import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        
        if (n > 0) {
            int sumByFormula = n * (n + 1) / 2;
            int sumByLoop = 0;
            int i = 1;
            
            while (i <= n) {
                sumByLoop += i;
                i++;
            }
            
            System.out.println("Sum using formula: " + sumByFormula);
            System.out.println("Sum using loop: " + sumByLoop);
            
            if (sumByFormula == sumByLoop) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("Both computations are not same.");
            }
        } else {
            System.out.println("The entered number is not a natural number.");
        }
    }
}
