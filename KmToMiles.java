import java.util.*;
public class KmToMiles {
    public static void main(String[] args) {
        double km;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the distance in kilometers : ");
        km = input.nextDouble();
        double mile = km/1.6;
        System.out.println("The total miles is " + mile + " mile for the given " + km + " km");
    }
}
