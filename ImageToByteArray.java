import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceFilePath = "originalImage.jpg";
        String destinationFilePath = "copiedImage.jpg";

        try {
            byte[] imageBytes = readImageToByteArray(sourceFilePath);
            writeByteArrayToImage(imageBytes, destinationFilePath);
            boolean isIdentical = compareFiles(sourceFilePath, destinationFilePath);
            System.out.println("Are the original and copied images identical? " + isIdentical);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static byte[] readImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
             
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    private static void writeByteArrayToImage(byte[] imageBytes, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filePath)) {
             
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    private static boolean compareFiles(String filePath1, String filePath2) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(new File(filePath1).toPath());
        byte[] file2Bytes = Files.readAllBytes(new File(filePath2).toPath());
        return Arrays.equals(file1Bytes, file2Bytes);
    }
}
