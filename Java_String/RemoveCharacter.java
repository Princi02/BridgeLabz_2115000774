package Java_String;

import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char charToRemove = sc.next().charAt(0);
        
        String result = str.replaceAll(String.valueOf(charToRemove), "");
        
        System.out.println("Modified String: \"" + result + "\"");
    }
}
