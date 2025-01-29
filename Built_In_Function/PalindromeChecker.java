import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        String input = takeInput();
        boolean isPalindrome = checkPalindrome(input);
        displayResult(isPalindrome);
    }

    private static String takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        sc.close();
        return input;
    }

    private static boolean checkPalindrome(String input) {
        input = input.replaceAll("[\\W_]+", "").toLowerCase();  // Removing non-alphanumeric characters and converting to lowercase
        int start = 0, end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static void displayResult(boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }
    }
}
