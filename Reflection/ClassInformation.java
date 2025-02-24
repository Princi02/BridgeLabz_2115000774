import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInformation {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();
        scanner.close();

        Class<?> cls = Class.forName(className);

        System.out.println("\nClass Name: " + cls.getName());

        System.out.println("\nMethods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method);
        }

        System.out.println("\nFields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field);
        }

        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : cls.getConstructors()) {
            System.out.println(constructor);
        }
    }
}
