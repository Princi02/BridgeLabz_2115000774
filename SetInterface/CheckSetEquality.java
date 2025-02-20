// package SetInterface;
import java.util.*;
public class CheckSetEquality {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        System.out.println("Set1 and Set2 are equal: " + areSetsEqual(set1, set2));
    }

    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2){
        if (set1.size() != set2.size()) return false;
        return set1.containsAll(set2);
    }
}
