import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value for a (integer): ");
        int a = scanner.nextInt();

        System.out.print("Enter value for b (integer): ");
        int b = scanner.nextInt();

        System.out.print("Enter value for c (integer): ");
        int c = scanner.nextInt();

        int result1 = a + b * c; // Multiplication has higher precedence than addition
        int result2 = a * b + c; // Multiplication happens first, then addition
        int result3 = c + a / b; // Division has higher precedence than addition
        int result4 = a % b + c; // Modulus happens first, then addition

        System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
    }
}
