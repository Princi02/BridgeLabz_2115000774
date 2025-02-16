import java.io.*;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        String fileName = "example.txt";
        String targetWord = "hello";
        int count = 0;

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equals(targetWord)) {
                    count++;
                }
            }
        }

        br.close();
        fr.close();

        System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");
    }
}
