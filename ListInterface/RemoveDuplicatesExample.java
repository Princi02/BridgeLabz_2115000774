package ListInterface;
import java.util.*;

public class RemoveDuplicatesExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 2, 3, 4));

        List<Integer> result = removeDuplicates(list);
        System.out.println(result);
    }

    public static List<Integer> removeDuplicates(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        List<Integer> newList = new ArrayList<>();
        int size = list.size()-1;
        for(int l : list){
            if(set.add(l)){
                newList.add(l);
            }
        }
        return newList;
    }
}
