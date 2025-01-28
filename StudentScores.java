import java.util.Random;
import java.util.Scanner;

public class StudentScores {

    public static int[][] generateScores(int numberOfStudents) {
        Random rand = new Random();
        int[][] scores = new int[numberOfStudents][3]; // 2D array to store scores for PCM for each student

        for (int i = 0; i < numberOfStudents; i++) {
            // Generate random 2-digit scores for Physics, Chemistry, and Maths
            scores[i][0] = 50 + rand.nextInt(50); // Physics (50 to 99)
            scores[i][1] = 50 + rand.nextInt(50); // Chemistry (50 to 99)
            scores[i][2] = 50 + rand.nextInt(50); // Maths (50 to 99)
        }

        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4]; // 2D array to store total, average, percentage for each student

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return results;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Scorecard:");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10.2f %-10.2f\n", 
                (i + 1), 
                scores[i][0], 
                scores[i][1], 
                scores[i][2], 
                (int) results[i][0], 
                results[i][1], 
                results[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        // Generate random scores
        int[][] scores = generateScores(numberOfStudents);

        // Calculate total, average, and percentage for each student
        double[][] results = calculateResults(scores);

        // Display the scorecard
        displayScorecard(scores, results);

        sc.close();
    }
}
