import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random rand = new Random();
        
        for (int size : sizes) {
            System.out.println("Testing with " + size + " elements");
            
            // Generate dataset
            int[] array = rand.ints(size, 1, size * 10).toArray();
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int num : array) {
                hashSet.add(num);
                treeSet.add(num);
            }
            int target = array[size / 2]; // Middle element as search target
            
            // Search in Array (Linear Search)
            long start = System.currentTimeMillis();
            for (int num : array) {
                if (num == target) break;
            }
            long end = System.currentTimeMillis();
            System.out.println("Array Search Time: " + (end - start) + " ms");
            
            // Search in HashSet (O(1))
            start = System.currentTimeMillis();
            boolean foundHashSet = hashSet.contains(target);
            end = System.currentTimeMillis();
            System.out.println("HashSet Search Time: " + (end - start) + " ms");
            
            // Search in TreeSet (O(log N))
            start = System.currentTimeMillis();
            boolean foundTreeSet = treeSet.contains(target);
            end = System.currentTimeMillis();
            System.out.println("TreeSet Search Time: " + (end - start) + " ms");
            
            System.out.println();
        }
    }
}
