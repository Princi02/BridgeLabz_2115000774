package ListInterface;
import java.util.*;
public class ReverseListExample {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> linkedList = new LinkedList<>(List.of(1, 2, 3, 4, 5));

        System.out.println("Original ArrayList: " + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        System.out.println("\nOriginal LinkedList: " + linkedList);
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }

    public static <T> void reverseList(List<T> list){
        int start = 0, end = list.size()-1;
        while(start < end){
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

}
