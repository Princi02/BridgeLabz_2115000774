package SetInterface;

import java.util.HashSet;
import java.util.Set;

public class Subset {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3, 4));
        boolean isSubset = isSubset(set1, set2);
        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }

    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        for (int element : set1) {
            if (!set2.contains(element)) {
                return false; 
            }
        }
        return true;
    }
}
