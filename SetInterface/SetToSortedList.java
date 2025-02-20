package SetInterface;

import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Set.of(5, 3, 9, 1));

        List<Integer> sortedList = convertToSortedList(set);
        System.out.println("Sorted List: " + sortedList); // Output: [1, 3, 5, 9]
    }

    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        sort(list);
        return list;
    }

    public static void sort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}

