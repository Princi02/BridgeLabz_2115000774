import java.util.*;
public class LeapYear1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year : ");

        int year = sc.nextInt();
        if(year >= 1582){
            if(year%4 == 0 && year%100 != 0){
                System.out.println("Given year is a Leap Year");
            }
            else if(year%400 == 0){
                System.out.println("Given year is a Leap Year");
            }
            else{
                System.out.println("Given year is not a Leap Year");
            }
        }
        else{
            System.out.println("Leap Year program does not work for year <= 1582");
        }
    }
}
