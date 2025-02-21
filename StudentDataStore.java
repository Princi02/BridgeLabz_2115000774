import java.io.*;

public class StudentDataStore {
    private static final String FILE_NAME = "studentData.bin";

    public static void main(String[] args) {
        writeStudentData(101, "John Doe", 3.8);
        readStudentData();
    }

    private static void writeStudentData(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }
    }

    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("Retrieved Student Data:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }
}
