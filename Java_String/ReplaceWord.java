// package Java_String;
import java.util.Scanner;
public class ReplaceWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String sentence = sc.nextLine();
        String wordToReplace = sc.next();
        String replacementWord = sc.next();
        
        String result = replaceWord(sentence, wordToReplace, replacementWord);
        System.out.println(result);
    }

    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words) {
            if (word.equals(wordToReplace)) {
                result += replacementWord + " ";
            } else {
                result += word + " ";
            }
        }

        return result.trim();
    }
}
