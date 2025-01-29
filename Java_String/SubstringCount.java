package Java_String;

import java.util.Scanner;

public class SubstringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String subStr = sc.nextLine();
        int count = 0;
        int index = 0;
        
        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }
        
        System.out.println(count);
    }
}

