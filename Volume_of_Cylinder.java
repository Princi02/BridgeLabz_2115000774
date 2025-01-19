import java.util.*;
public class Volume_of_Cylinder{
	public static void main(String args[]){
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the radius: ");
		double radius = sc.nextDouble();
		System.out.print("Enter the height: ");
		double height = sc.nextDouble();
		double volume = Math.PI * Math.pow(radius, 2) * height;
		System.out.println("Volume of the cylinder is: " + volume);
        sc.close();
	}
}