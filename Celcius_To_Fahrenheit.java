import java.util.Scanner;
public class Celcius_To_Fahrenheit{
	public static void main(String args[]){
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter temperature in Celsius: ");
		double cel = sc.nextDouble();
		double fahr = (cel * 9/5) + 32;
		System.out.println("Temperature in Fahrenheit: " + fahr);
        sc.close();
	}
}