import java.util.Scanner;

public class FriendsDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter Amar's height: ");
        int amarHeight = sc.nextInt();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter Akbar's height: ");
        int akbarHeight = sc.nextInt();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Enter Anthony's height: ");
        int anthonyHeight = sc.nextInt();

        String youngest = (amarAge < akbarAge && amarAge < anthonyAge) ? "Amar" :(akbarAge < anthonyAge) ? "Akbar" : "Anthony";

        String tallest = (amarHeight > akbarHeight && amarHeight > anthonyHeight) ? "Amar" :(akbarHeight > anthonyHeight) ? "Akbar" : "Anthony";

        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
    }
}
