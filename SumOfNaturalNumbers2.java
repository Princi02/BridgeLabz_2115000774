import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("The number must be a natural number greater than 0.");
            return;
        }
        
        // Calculate the sum using recursion
        int recursiveSum = calculateSumRecursively(n);
        
        // Calculate the sum using the formula
        int formulaSum = calculateSumUsingFormula(n);
        
        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);
        
        if (recursiveSum == formulaSum) {
            System.out.println("Both methods give the correct and same result.");
        } else {
            System.out.println("There is an error in the calculations.");
        }
    }

    public static int calculateSumRecursively(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + calculateSumRecursively(n - 1);
        }
    }

    public static int calculateSumUsingFormula(int n) {
        return (n * (n + 1)) / 2;
    }
}
