package Java_String;
import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the main string:");
        String mainStr = sc.nextLine();
        
        System.out.println("Enter the substring to find:");
        String subStr = sc.nextLine();
        
        int mainLen = mainStr.length();
        int subLen = subStr.length();
        int count = 0;

        for (int i = 0; i <= mainLen - subLen; i++) {
            boolean match = true;
            
            for (int j = 0; j < subLen; j++) {
                if (mainStr.charAt(i + j) != subStr.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        System.out.println("Occurrences: " + count);
        sc.close();
    }
}
