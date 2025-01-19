import java.util.Scanner;
public class AddTwoNumbers{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter FirstNum: ");
		int FirstNum = sc.nextInt();
		System.out.println("Enter SecondNum: ");
		int SecondNum = sc.nextInt();
		int result = FirstNum + SecondNum;
		System.out.println("Sum: " + result);
	}
}