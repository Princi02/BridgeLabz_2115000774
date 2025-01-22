// Create AverageMarks class to compute average marks of sam
public class AverageMarks{
    public static void main(String[] args) {
        // Create a variable mathsMark to indicate mark in maths of sam
        int mathsMark = 94;
        // Create a variable physicsMark to indicate mark in phyiscs of sam
        int physicsMark = 95;
        // Create a variable chemistryMark to indicate mark in chemistry of sam 
        int chemistryMark = 96;
        // Create a variable averageMark to indicate average marks in PCM
        Double averageMark = (double)(mathsMark + physicsMark + chemistryMark)/3;

        // Print the average marks
        System.out.println("Sam's average mark in PCM is "+averageMark);
    }
}