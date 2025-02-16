import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) throws IOException {
        int iterations = 1_000_000;
        String str = "hello";

        long startTime, endTime;

        // StringBuilder Performance
        StringBuilder sb = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sb.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");

        // StringBuffer Performance
        StringBuffer sbf = new StringBuffer();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sbf.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");

        // FileReader Word Count
        startTime = System.nanoTime();
        int wordCountFileReader = countWordsUsingFileReader("largefile.txt");
        endTime = System.nanoTime();
        System.out.println("FileReader word count: " + wordCountFileReader);
        System.out.println("FileReader time: " + (endTime - startTime) / 1_000_000 + " ms");

        // InputStreamReader Word Count
        startTime = System.nanoTime();
        int wordCountInputStream = countWordsUsingInputStreamReader("largefile.txt");
        endTime = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCountInputStream);
        System.out.println("InputStreamReader time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static int countWordsUsingFileReader(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        int wordCount = 0;
        String line;

        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }

        br.close();
        fr.close();
        return wordCount;
    }

    public static int countWordsUsingInputStreamReader(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        int wordCount = 0;
        String line;

        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }

        br.close();
        isr.close();
        fis.close();
        return wordCount;
    }
}
