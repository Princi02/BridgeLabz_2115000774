import java.util.Arrays;

public class CountingSortAges {
    public static void countingSort(int[] ages, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age - min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 18, 14, 12, 17, 11, 13, 15, 16};
        countingSort(studentAges, 10, 18);
        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
    }
}
