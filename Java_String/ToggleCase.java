package Java_String;
import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result += (char) (ch + 32); // Convert uppercase to lowercase
            } else if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32); // Convert lowercase to uppercase
            } else {
                result += ch; // Keep non-alphabetic characters unchanged
            }
        }

        System.out.println(result);
        sc.close();
    }
}
