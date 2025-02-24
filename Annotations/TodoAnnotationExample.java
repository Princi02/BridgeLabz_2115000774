import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void authenticateUser() {
        System.out.println("Authenticating user...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Optimizing database...");
    }

    @Todo(task = "Add logging for errors", assignedTo = "Charlie", priority = "LOW")
    public void addLogging() {
        System.out.println("Adding logging...");
    }
}

public class TodoAnnotationExample {
    public static void main(String[] args) {
        Method[] methods = Project.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Task: " + annotation.task() + 
                ", Assigned To: " + annotation.assignedTo() + 
                ", Priority: " + annotation.priority());
            }
        }
    }
}
