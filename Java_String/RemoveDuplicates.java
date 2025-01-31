// package Java_String;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "programming";
        String result = "";
        boolean found;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            found = false;

            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == ch) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                result += ch;
            }
        }

        System.out.println(result);
    }
}
