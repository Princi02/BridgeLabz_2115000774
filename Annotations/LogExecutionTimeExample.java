import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTest {
    
    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {
            Math.sqrt(i);
        }
    }
    
    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }
    }
}

public class LogExecutionTimeExample {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(test);
                long end = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " + (end - start) + " ns");
            }
        }
    }
}
