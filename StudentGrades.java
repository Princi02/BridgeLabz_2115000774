import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        int[] physics = new int[numStudents];
        int[] chemistry = new int[numStudents];
        int[] maths = new int[numStudents];
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");

            do {
                System.out.print("Physics marks: ");
                physics[i] = sc.nextInt();
                if (physics[i] < 0) {
                    System.out.println("Marks cannot be negative. Please enter again.");
                }
            } while (physics[i] < 0);

            do {
                System.out.print("Chemistry marks: ");
                chemistry[i] = sc.nextInt();
                if (chemistry[i] < 0) {
                    System.out.println("Marks cannot be negative. Please enter again.");
                }
            } while (chemistry[i] < 0);

            do {
                System.out.print("Maths marks: ");
                maths[i] = sc.nextInt();
                if (maths[i] < 0) {
                    System.out.println("Marks cannot be negative. Please enter again.");
                }
            } while (maths[i] < 0);
        }

        for (int i = 0; i < numStudents; i++) {
            int totalMarks = physics[i] + chemistry[i] + maths[i];
            percentages[i] = (totalMarks / 300.0) * 100;

            if (percentages[i] >= 90) {
                grades[i] = "A";
            } else if (percentages[i] >= 80) {
                grades[i] = "B";
            } else if (percentages[i] >= 70) {
                grades[i] = "C";
            } else if (percentages[i] >= 60) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        System.out.println("\nStudent Details:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + physics[i] + ", Chemistry: " + chemistry[i] + ", Maths: " + maths[i]);
            System.out.println("Percentage: " + percentages[i] + "%, Grade: " + grades[i]);
        }
    }
}
