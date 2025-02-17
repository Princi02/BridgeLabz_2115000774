import java.util.Random;
import java.util.Arrays;

public class SortingAlgos {

    public static void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int arr[], int left, int right){
        int mid = left + (right-left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int arr[], int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
        System.arraycopy(arr, left, arr1, 0, n1);
        System.arraycopy(arr, mid+1, arr2, 0, n2);
        int i=0, j=0, k=left;
        while(i<n1 && j<n2){
            arr[k++] = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++]; 
        }
        while(i<n1){
            arr[k++] = arr1[i++];
        }
        while(j<n2){
            arr[k++] = arr1[j++];
        }
    }


     public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();
        
        for (int size : sizes) {
            int[] array = rand.ints(size, 1, 1000000).toArray();
            
            int[] arr1 = Arrays.copyOf(array, array.length);
            int[] arr2 = Arrays.copyOf(array, array.length);
            int[] arr3 = Arrays.copyOf(array, array.length);
            
            System.out.println("Sorting array of size: " + size);
            
            long start = System.currentTimeMillis();
            bubbleSort(arr1);
            long end = System.currentTimeMillis();
            System.out.println("Bubble Sort: " + (end - start) + " ms");
            
            start = System.currentTimeMillis();
            mergeSort(arr2, 0, arr2.length - 1);
            end = System.currentTimeMillis();
            System.out.println("Merge Sort: " + (end - start) + " ms");
            
            start = System.currentTimeMillis();
            quickSort(arr3, 0, arr3.length - 1);
            end = System.currentTimeMillis();
            System.out.println("Quick Sort: " + (end - start) + " ms");
            
            System.out.println();
        }
    }

    
}
