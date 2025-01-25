import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the age of " + friends[i] + ":");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid age:");
                sc.next();
            }
            ages[i] = sc.nextInt();

            System.out.println("Enter the height of " + friends[i] + " (in cm):");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid height:");
                sc.next();
            }
            heights[i] = sc.nextDouble();
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("The youngest friend is " + friends[youngestIndex] + " with an age of " + ages[youngestIndex] + " years.");
        System.out.println("The tallest friend is " + friends[tallestIndex] + " with a height of " + heights[tallestIndex] + " cm.");
    }
}
