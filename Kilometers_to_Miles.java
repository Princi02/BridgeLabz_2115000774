import java.util.*;
public class Kilometers_to_Miles{
	public static void main(String args[]){
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the distance in km: ");
        double km_distance = sc.nextDouble();
        double km_miles = km_distance * 0.621371;
		System.out.println("Distance in miles: " + km_miles);
        sc.close();
	}
}