import java.util.Scanner;

public class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] multiplicationResult = new int[4]; // Array to store results for numbers 6 to 9

        for (int number = 6; number <= 9; number++) {
            System.out.println("Multiplication Table for " + number + ":");
            for (int i = 1; i <= 10; i++) {
                multiplicationResult[i - 1] = number * i;
                System.out.println(number + " * " + i + " = " + multiplicationResult[i - 1]);
            }
            System.out.println();
        }
    }
}
