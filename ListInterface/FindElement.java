package ListInterface;
import java.util.*;
public class FindElement {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(List.of("A", "B", "C", "D", "E"));
        int n=2;
        String result = findNthFromEnd(list, n);
        if (result != null) {
            System.out.println("The " + n + "th element from the end is: " + result);
        } else {
            System.out.println("Invalid N or list is too short.");
        }

    }

    public static String findNthFromEnd(LinkedList<String> list, int n){
        if (n <= 0) return null;
        ListIterator<String> fast = list.listIterator();
        ListIterator<String> slow = list.listIterator();

        for(int i=0; i<n; i++){
            if(fast.hasNext()){
                fast.next();
            }
        }

        while(fast.hasNext()){
            fast.next();
            slow.next();
        }

        return slow.next();
    }
}
