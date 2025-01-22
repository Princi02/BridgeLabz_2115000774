import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the city you are traveling from: ");
        String fromCity = scanner.nextLine();

        System.out.print("Enter the city you are traveling via: ");
        String viaCity = scanner.nextLine();

        System.out.print("Enter the city you are traveling to: ");
        String toCity = scanner.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = scanner.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = scanner.nextDouble();

        System.out.print("Enter the time taken for the trip (in hours): ");
        double timeTaken = scanner.nextDouble();

        // Calculate the total distance
        double totalDistance = fromToVia + viaToFinalCity;

        // Calculate average speed
        double averageSpeed = totalDistance / timeTaken;

        System.out.println("Travel Details for " + name + ":");
        System.out.println("The total distance traveled from " + fromCity + " to " + viaCity + " to " + toCity + " is " + totalDistance + " miles.");
        System.out.println("The average speed during the trip was " + averageSpeed + " miles per hour.");
    }
}


