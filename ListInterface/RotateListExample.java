package ListInterface;
import java.util.*;
public class RotateListExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(4,3,5,7,8,9));

        int positions = 2;
        rotate(list, 2);
        System.out.println(list);;
    }

    public static <T> void rotate(List<T> list, int positions){
        int size = list.size();
        if(size == 0) return;
        positions = positions % size;
        if(positions < 0) positions+=size;

        reverse(list, 0, size-1);
        reverse(list, 0, size-positions-1);
        reverse(list, size-positions, size-1);
    }

    public static <T> void reverse(List<T> list, int start, int end){
        while(start < end){
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
}
