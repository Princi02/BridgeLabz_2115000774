import java.util.*;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Boolean isPrime = true;
        for(int i=2; i<number; i++){
            if(number%i == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println("The given number is a Prime number");
        }
        else{
            System.out.println("The given number is not a Prime number");
        }
    }
}
