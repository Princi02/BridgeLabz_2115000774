package SetInterface;

import java.util.*;

public class UnionIntersectionWithoutInbuilt {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        Set<Integer> union = findUnion(set1, set2);
        Set<Integer> intersection = findIntersection(set1, set2);

        System.out.println("Union: " + union);     
        System.out.println("Intersection: " + intersection); 
    }

    public static Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>();

        for (Integer element : set1) {
            union.add(element);
        }

        for (Integer element : set2) {
            if (!union.contains(element)) {
                union.add(element);
            }
        }
        return union;
    }

    public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>();

        for (Integer element : set1) {
            for (Integer elem2 : set2) {
                if (element.equals(elem2)) {
                    intersection.add(element);
                    break; 
                }
            }
        }
        return intersection;
    }
}
