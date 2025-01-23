import java.util.*;
public class GradeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first subject name : ");
        String subject1 = sc.next();
        System.out.println("Enter the marks in first subject: ");
        int mark1 = sc.nextInt();
        
        System.out.println("Enter the second subject name: ");
        String subject2 = sc.next();
        System.out.println("Enter the marks in second subject: ");
        int mark2 = sc.nextInt();
        
        System.out.println("Enter the third subject name: ");
        String subject3 = sc.next();
        System.out.println("Enter the marks in third subject: ");
        int mark3 = sc.nextInt();
        int totalMarks = mark1 + mark2 + mark3;
        double percentage = (double)(totalMarks/3)*100;
        double AverageMarks = totalMarks/3;
        if(percentage >= 80.0){
            System.out.println("Average marks: " + AverageMarks + ",\nGrade: A" + " \nRemarks: Level 4, above agency-normalized standards" );
        }
        else if(percentage < 80.0 && percentage >=70.0){
            System.out.println("Average marks: " + AverageMarks + ",\nGrade: B" + " \nRemarks: Level 3, at agency-normalized standards" );         
        }
        else if(percentage < 70.0 && percentage >=60.0){
            System.out.println("Average marks: " + AverageMarks + ",\nGrade: C" + " \nRemarks: Level 2, below agency-normalized standards" );         
        }
        else if(percentage < 60.0 && percentage >= 50.0){
            System.out.println("Average marks: " + AverageMarks + ",\nGrade: D" + " \nRemarks: Level 1, well below agency-normalized standards" );         
        }
        else if(percentage < 50.0 && percentage >=40.0){
            System.out.println("Average marks: " + AverageMarks + ",\nGrade: E" + " \nRemarks: Level 1, too below agency-normalized standards" );         
        }
        else{
            System.out.println("Average marks: " + AverageMarks + " \nRemedial standards" ); 
        }
    }
}