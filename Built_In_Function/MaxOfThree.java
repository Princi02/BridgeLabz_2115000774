package Built_In_Function;
import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        int[] numbers = takeInput();
        int max = findMax(numbers[0], numbers[1], numbers[2]);
        System.out.println("The maximum value is: " + max);
    }

    private static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        return new int[]{a, b, c};
    }

    private static int findMax(int a, int b, int c) {
        return (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
    }
}
