package SetInterface;

import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        Set<Integer> symmetricDifference = findSymmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symmetricDifference); 
    }

    public static Set<Integer> findSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>();

        for (int element : set1) {
            if (!set2.contains(element)) {
                result.add(element);
            }
        }

        for (int element : set2) {
            if (!set1.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }
}

