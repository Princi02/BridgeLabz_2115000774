import java.util.Random;

public class FootballTeamHeights2 {

    public static void main(String[] args) {
        int[] heights = new int[11];
        Random random = new Random();

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + random.nextInt(101); // 150 to 250 inclusive
        }

        System.out.print("Heights of players: ");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println();

        int sum = findSum(heights);
        double mean = findMean(sum, heights.length);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        System.out.println("Sum of heights: " + sum + " cm");
        System.out.println("Mean height: " + mean + " cm");
        System.out.println("Shortest height: " + shortest + " cm");
        System.out.println("Tallest height: " + tallest + " cm");
    }

    // Method to find the sum of all elements in the array
    public static int findSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    // Method to find the mean height of the players
    public static double findMean(int sum, int count) {
        return (double) sum / count;
    }

    // Method to find the shortest height in the array
    public static int findShortest(int[] array) {
        int shortest = array[0];
        for (int num : array) {
            if (num < shortest) {
                shortest = num;
            }
        }
        return shortest;
    }

    // Method to find the tallest height in the array
    public static int findTallest(int[] array) {
        int tallest = array[0];
        for (int num : array) {
            if (num > tallest) {
                tallest = num;
            }
        }
        return tallest;
    }
}
