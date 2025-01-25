import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        int[][] marks = new int[numStudents][3]; // 2D array to store marks for physics, chemistry, and maths
        double[] percentages = new double[numStudents]; 
        String[] grades = new String[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");

            do {
                System.out.print("Physics marks: ");
                marks[i][0] = sc.nextInt();
                if (marks[i][0] < 0) {
                    System.out.println("Marks cannot be negative. Please enter again.");
                }
            } while (marks[i][0] < 0);

            do {
                System.out.print("Chemistry marks: ");
                marks[i][1] = sc.nextInt();
                if (marks[i][1] < 0) {
                    System.out.println("Marks cannot be negative. Please enter again.");
                }
            } while (marks[i][1] < 0);

            do {
                System.out.print("Maths marks: ");
                marks[i][2] = sc.nextInt();
                if (marks[i][2] < 0) {
                    System.out.println("Marks cannot be negative. Please enter again.");
                }
            } while (marks[i][2] < 0);
        }

        for (int i = 0; i < numStudents; i++) {
            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
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
            System.out.println("Physics: " + marks[i][0] + ", Chemistry: " + marks[i][1] + ", Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentages[i] + "%, Grade: " + grades[i]);
        }
    }
}
