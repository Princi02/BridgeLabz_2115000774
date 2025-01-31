package Built_In_Function;
import java.util.Scanner;

public class TemperatureConverter {
    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to convert Fahrenheit to Celsius, 2 for Celsius to Fahrenheit:");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Enter temperature in Fahrenheit:");
            double f = sc.nextDouble();
            System.out.println("Celsius: " + fahrenheitToCelsius(f));
        } else if (choice == 2) {
            System.out.println("Enter temperature in Celsius:");
            double c = sc.nextDouble();
            System.out.println("Fahrenheit: " + celsiusToFahrenheit(c));
        } else {
            System.out.println("Invalid choice");
        }
        sc.close();
    }
}
