package Java_String;

import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "programming";
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (Character ch : set) {
            result.append(ch);
        }
        System.out.println(result.toString());
    }
}

