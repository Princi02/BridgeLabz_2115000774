import java.util.Scanner;

public class FriendComparison {

    public static int findYoungest(int[] ages) {
        int youngest = ages[0];
        for (int age : ages) {
            if (age < youngest) {
                youngest = age;
            }
        }
        return youngest;
    }

    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[3];
        int[] heights = new int[3];

        System.out.print("Enter age of Amar: ");
        ages[0] = sc.nextInt();
        System.out.print("Enter age of Akbar: ");
        ages[1] = sc.nextInt();
        System.out.print("Enter age of Anthony: ");
        ages[2] = sc.nextInt();

        System.out.print("Enter height of Amar (in cm): ");
        heights[0] = sc.nextInt();
        System.out.print("Enter height of Akbar (in cm): ");
        heights[1] = sc.nextInt();
        System.out.print("Enter height of Anthony (in cm): ");
        heights[2] = sc.nextInt();

        int youngestAge = findYoungest(ages);
        int tallestHeight = findTallest(heights);

        System.out.println("The youngest age is: " + youngestAge + " years.");
        System.out.println("The tallest height is: " + tallestHeight + " cm.");
        
        sc.close();
    }
}
