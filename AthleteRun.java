import java.util.Scanner;

public class AthleteRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side1 of the triangle (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of side2 of the triangle (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of side3 of the triangle (in meters): ");
        double side3 = scanner.nextDouble();
        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000;
        double rounds = totalDistance / perimeter;

        System.out.println("The total number of rounds the athlete will run is " + rounds);
    }
}
