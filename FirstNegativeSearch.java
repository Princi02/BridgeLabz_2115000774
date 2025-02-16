public class FirstNegativeSearch {
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, -4, 5, -9, 2};
        int index = findFirstNegative(arr);
        System.out.println("First negative number index: " + index);
    }

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
