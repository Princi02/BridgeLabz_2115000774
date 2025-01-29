package Java_String;

import java.util.Scanner;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] freq = new int[256];  // Assuming ASCII characters
        
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        
        int maxCount = 0;
        char mostFrequentChar = ' ';
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (freq[currentChar] > maxCount) {
                maxCount = freq[currentChar];
                mostFrequentChar = currentChar;
            }
        }
        
        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
    }
}

