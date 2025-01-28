import java.util.Scanner;

public class TriangularParkRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = sc.nextDouble();
        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = sc.nextDouble();
        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = sc.nextDouble();
        double perimeter = calculatePerimeter(side1, side2, side3);
        double rounds = calculateRounds(perimeter, 5000);
        System.out.println("The athlete needs to complete " + (int) Math.ceil(rounds) + " rounds to complete a 5 km run.");
    }

    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    public static double calculateRounds(double perimeter, double distance) {
        return distance / perimeter;
    }
}
