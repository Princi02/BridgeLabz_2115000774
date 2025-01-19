import java.util.*;
public class Power_Calculation{
	public static void main(String args[]){
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the base: ");
        double base = sc.nextDouble();
        System.out.print("Enter the exponent: ");
        int exp = sc.nextInt();
        double ans = Math.pow(base, exp);
		System.out.println("Result: " + ans);
        sc.close();
	}
}