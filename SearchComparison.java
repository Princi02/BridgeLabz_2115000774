import java.util.*;
public class SearchComparison {
    public static void main(String[] args) {
        int sizes[] = {1000, 10000, 1000000};
        Random random = new Random();
        for(int size : sizes){
            int arr[] = new int[size];
            int target = arr[random.nextInt(size)];
            for(int i=0; i<size; i++){
                arr[i] = random.nextInt(size);
            }

            // Linear search
            long startTime = System.nanoTime();
            linearSearch(arr, target);
            long linearTime = System.nanoTime() - startTime;

             // Sort the array for Binary Search
            Arrays.sort(arr);
            
            // Binary Search (without predefined method)
            startTime = System.nanoTime();
            binarySearch(arr, target);
            long binaryTime = System.nanoTime() - startTime;
            
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1e6 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1e6 + " ms");
            System.out.println();


        }
    }


    public static int linearSearch(int arr[], int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target) return i;
        }
        return -1;
    }


    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
