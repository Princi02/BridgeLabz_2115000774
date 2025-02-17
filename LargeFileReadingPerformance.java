import java.io.*;

public class LargeFileReadingPerformance {
    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt"; // Replace with actual file path
        
        // Using FileReader (Character Stream)
        long start = System.currentTimeMillis();
        FileReader fileReader = new FileReader(filePath);
        char[] buffer = new char[8192]; // Using a buffer for efficiency
        while (fileReader.read(buffer) != -1);
        fileReader.close();
        long end = System.currentTimeMillis();
        System.out.println("FileReader Time: " + (end - start) + " ms");
        
        // Using InputStreamReader (Byte Stream)
        start = System.currentTimeMillis();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        while (inputStreamReader.read(buffer) != -1);
        inputStreamReader.close();
        end = System.currentTimeMillis();
        System.out.println("InputStreamReader Time: " + (end - start) + " ms");
    }
}
