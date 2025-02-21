import java.io.*;

public class FileCopyPerformanceComparison {
    private static final String SOURCE_FILE = "largeFile.txt"; // Replace with a 100MB+ file
    private static final String DEST_FILE_UNBUFFERED = "unbufferedCopy.txt";
    private static final String DEST_FILE_BUFFERED = "bufferedCopy.txt";
    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {
        long unbufferedTime = copyFileUnbuffered(SOURCE_FILE, DEST_FILE_UNBUFFERED);
        long bufferedTime = copyFileBuffered(SOURCE_FILE, DEST_FILE_BUFFERED);

        System.out.println("Unbuffered copy time: " + unbufferedTime + " ns (" + (unbufferedTime / 1_000_000) + " ms)");
        System.out.println("Buffered copy time: " + bufferedTime + " ns (" + (bufferedTime / 1_000_000) + " ms)");

        if (bufferedTime < unbufferedTime) {
            System.out.println("Buffered streams are faster by " + (unbufferedTime - bufferedTime) + " ns.");
        } else {
            System.out.println("Unbuffered streams are faster by " + (bufferedTime - unbufferedTime) + " ns.");
        }
    }

    // Unbuffered file copy
    private static long copyFileUnbuffered(String sourceFile, String destFile) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered Error: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }

    // Buffered file copy
    private static long copyFileBuffered(String sourceFile, String destFile) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered Error: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }
}
