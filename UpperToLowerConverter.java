import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        String sourceFilePath = "source.txt";
        String destinationFilePath = "lowercaseOutput.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {
             
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File conversion to lowercase completed.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
