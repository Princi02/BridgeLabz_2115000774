package MapInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "sample.txt"; 
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                line = line.toLowerCase().replaceAll("[^a-z\\s]", "");

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        wordCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }
}

