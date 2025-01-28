import java.util.Scanner;

public class BMICalculator {
    public static double[][] findBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double heightInMeters = data[i][1] / 100; // Convert cm to meters
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters); // Calculate BMI
        }
        return data;
    }

    public static String[] determineStatus(double[][] data) {
        String[] statuses = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                statuses[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 29.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obesity";
            }
        }
        return statuses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3]; // 2D array to store weight, height, and BMI

        for (int i = 0; i < data.length; i++) {
            System.out.println("Enter weight (in kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.println("Enter height (in cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        findBMI(data);
        String[] statuses = determineStatus(data);

        System.out.println("Height(cm) | Weight(kg) | BMI | Status");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%.2f cm    | %.2f kg    | %.2f | %s%n", data[i][1], data[i][0], data[i][2], statuses[i]);
        }

        sc.close();
    }
}
