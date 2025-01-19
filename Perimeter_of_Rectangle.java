import java.util.*;
public class Perimeter_of_Rectangle{
	public static void main(String args[]){
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the length: ");
        double length = sc.nextDouble();
        System.out.print("Enter the width: ");
        double width = sc.nextDouble();
        double perimeter = 2 * (length + width);
		System.out.println("The Perimeter is: " + perimeter);
        sc.close();
	}
}