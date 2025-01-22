import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the base of the triangle (in cm): ");
        double base = input.nextDouble();

        System.out.print("Enter the height of the triangle (in cm): ");
        double height = input.nextDouble();

        double areaInCm = 0.5 * base * height;
        double areaInInches = areaInCm / 6.4516;

        System.out.println("The area of the triangle is " + areaInCm + " square centimeters and " + areaInInches + " square inches.");
    }
}
