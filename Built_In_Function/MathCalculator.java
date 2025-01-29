import java.util.*;

class MathCalculator {
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        return new int[]{a, b};
    }

    static void displayResult(int gcd, int lcm) {
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    public static void main(String[] args) {
        int[] numbers = getInput();
        int gcdResult = gcd(numbers[0], numbers[1]);
        int lcmResult = lcm(numbers[0], numbers[1]);
        displayResult(gcdResult, lcmResult);
    }
}
