import java.util.*;
public class Average_of_three_num{
	public static void main(String args[]){
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter number1: ");
        double number1 = sc.nextDouble();
        System.out.print("Enter number2: ");
        double number2 = sc.nextDouble();
		System.out.print("Enter number3: ");
        double number3 = sc.nextDouble();
        double avg = (number1 + number2 + number3)/3;
		System.out.println("Average is: " + avg);
        sc.close();
	}
}