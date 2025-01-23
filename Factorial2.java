import java.util.Scanner;

public class Factorial2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int number = sc.nextInt();
        
        if (number >= 0) {
            int factorial = 1;
            for(int i=1 ; i<=number ; i++) {
                factorial *= i;
            }
            
            System.out.println("The factorial is: " + factorial);
        } else {
            System.out.println("Please enter a positive integer.");
        }
    }
}
