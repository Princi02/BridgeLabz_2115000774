import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Initialize the map with sum 0 at index -1 to handle cases where prefix itself is zero
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Compute cumulative sum

            // If this sum has been seen before, it means subarrays exist
            if (sumMap.containsKey(sum)) {
                for (int startIndex : sumMap.get(sum)) {
                    result.add(new int[]{startIndex + 1, i}); // Store subarray indices
                }
            }

            // Add current index to list of occurrences of this sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        // Print the subarrays
        for (int[] range : subarrays) {
            System.out.println("Subarray found from index " + range[0] + " to " + range[1]);
        }
    }
}
