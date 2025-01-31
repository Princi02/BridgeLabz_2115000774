import java.util.*;
public class Circle {
    double radius;
    Circle(double radius){
        this.radius = radius;
    }
    public double area(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double circumference (){
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        Circle circle  = new Circle(4);
        double areaOfCircle = circle.area();
        double circumferenceOfCircle = circle.circumference();

        System.out.println("Area of the circle is : " + areaOfCircle);
        System.out.println("Circumference of the circle is : " + circumferenceOfCircle);
    }

}
