import java.util.Scanner;

public class FindFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        
        if (!sc.hasNextInt()) {
            System.out.println("Error! Please enter a valid integer.");
            return;
        }
        
        int number = sc.nextInt();
        
        if (number <= 0) {
            System.out.println("Error! Please enter a positive integer.");
            return;
        }

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // Find factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index == maxFactor) {
                    maxFactor *= 2;  // Double the size of the array
                    int[] temp = new int[maxFactor];
                    
                    // Copy elements from factors array to temp array
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    
                    factors = temp;  // Assign temp array back to factors
                }
                factors[index++] = i;  // Store the factor
            }
        }

        // Display factors
        System.out.print("Factors of " + number + ": ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
    }
}
