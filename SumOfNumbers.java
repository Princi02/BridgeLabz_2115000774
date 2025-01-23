import java.util.Scanner;
public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double total = 0.0;
        double number;
        
        System.out.println("Enter numbers to add to the total. Enter 0 to stop.");
        while (true) {
            System.out.print("Enter a number: ");
            number = sc.nextDouble();
            
            if (number == 0) {
                break;
            }
            total += number;
        }
        System.out.println("The total is: " + total);
    }
}
