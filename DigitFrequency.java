import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = new int[10];
        int[] frequency = new int[10];

        while (number != 0) {
            int digit = number % 10;
            digits[digit]++;
            number /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (digits[i] > 0) {
                System.out.println("Digit " + i + " appears " + digits[i] + " times.");
            }
        }
    }
}
