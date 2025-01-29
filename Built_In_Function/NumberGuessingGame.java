import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lowerBound = 1, upperBound = 100;
        String feedback;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("The computer will try to guess it.");
        
        do {
            int guess = generateGuess(lowerBound, upperBound);
            feedback = getFeedback(guess);
            if (feedback.equals("high")) {
                upperBound = guess - 1;
            } else if (feedback.equals("low")) {
                lowerBound = guess + 1;
            }
        } while (!feedback.equals("correct"));
        
        System.out.println("Yay! The computer guessed your number!");
        sc.close();
    }

    private static int generateGuess(int lowerBound, int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    private static String getFeedback(int guess) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is the guess " + guess + "? (Enter 'high', 'low', or 'correct')");
        return sc.nextLine().toLowerCase();
    }
}
