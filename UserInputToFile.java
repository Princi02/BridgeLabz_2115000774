import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) throws IOException {
        String fileName = "output.txt";

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        FileWriter fw = new FileWriter(fileName);

        System.out.println("Enter text (type 'exit' to stop):");

        String line;
        while (!(line = br.readLine()).equals("exit")) {
            fw.write(line + "\n");
        }

        br.close();
        isr.close();
        fw.close();
        System.out.println("Input saved to " + fileName);
    }
}
