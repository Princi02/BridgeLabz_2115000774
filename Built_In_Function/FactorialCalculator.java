package Built_In_Function;
import java.util.*;

class FactorialCalculator {
    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    static int getInput() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        return num;
    }

    static void displayResult(int result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        int num = getInput();
        int result = factorial(num);
        displayResult(result);
    }
}
