package Level1PracticeQuestions;
import java.util.*;
public class Circle {
    double radius;

    public Circle(){
        this(1.0);
    }
    public Circle(double radius){
        this.radius  = radius;
    }
     // Method to calculate the area of the circle
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate the circumference of the circle
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void display(){
        System.out.println("Circle with radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle circle1 = new Circle();
        circle1.display();
        System.out.println("Enter the value of radius : ");
        double userRadius = sc.nextDouble();
        Circle circle2 = new Circle(userRadius);
        circle2.display();
        sc.close();
    }

}
