package Built_In_Function;
import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date (YYYY-MM-DD):");
        LocalDate date = LocalDate.parse(sc.next());
        
        LocalDate modifiedDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        
        System.out.println("Final Date after modifications: " + modifiedDate);
        sc.close();
    }
}
