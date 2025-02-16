import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String fileName = "example.txt";

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        fr.close();
    }
}
