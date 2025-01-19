import java.util.*;
public class SimpleInterest{
	public static void main(String args[]){
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the amount of principal: ");
		double p = sc.nextDouble();
		System.out.print("Enter the rate of interest: ");
		double r = sc.nextDouble();
        System.out.print("Enter the time period: ");
        double t = sc.nextDouble();
		double interest = (p * r * t)/100;
		System.out.println("The simple interest is: " + interest);
        sc.close();
	}
}