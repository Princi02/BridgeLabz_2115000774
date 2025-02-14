import java.util.Arrays;

public class InsertionSortEmployeeIDs {
    public static void insertionSort(int[] employeeIDs){
        int n = employeeIDs.length;
        for(int i=1; i<n; i++){
            int key = employeeIDs[i];
            int j = i - 1;
            while(j>=0 && employeeIDs[j] > key){
                employeeIDs[j+1] = employeeIDs[j];
                j--;
            } 
            employeeIDs[j+1] = key;
        }

    }

    public static void main(String[] args) {
        int[] employeeIDs = {104, 101, 109, 103, 108, 102};
        insertionSort(employeeIDs);
        System.out.println("Sorted Employee IDs: " + Arrays.toString(employeeIDs));
    }
}
