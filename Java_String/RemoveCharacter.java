// package Java_String;

import java.util.Scanner;
public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char charToRemove = sc.next().charAt(0);

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != charToRemove) {
                result += str.charAt(i);
            }
        }

        System.out.println("Modified String: \"" + result + "\"");
    }
}

