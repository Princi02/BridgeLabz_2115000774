import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value for a (double): ");
        double a = scanner.nextDouble();

        System.out.print("Enter value for b (double): ");
        double b = scanner.nextDouble();

        System.out.print("Enter value for c (double): ");
        double c = scanner.nextDouble();

        double result1 = a + b * c; // Multiplication happens first
        double result2 = a * b + c; // Multiplication happens first, then addition
        double result3 = c + a / b; // Division happens first, then addition
        double result4 = a % b + c; // Modulus happens first, then addition

        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
    }
}
