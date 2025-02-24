package Reflection;

import java.lang.reflect.Method;

class Operations {
    public void fastOperation() {
        for (int i = 0; i < 1000; i++) {
            int x = i * i;
        }
        System.out.println("Fast operation completed.");
    }

    public void slowOperation() {
        for (int i = 0; i < 1000000; i++) {
            int x = i * i;
        }
        System.out.println("Slow operation completed.");
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        Operations operations = new Operations();
        Method[] methods = Operations.class.getDeclaredMethods();

        for (Method method : methods) {
            long startTime = System.nanoTime();
            method.invoke(operations);
            long endTime = System.nanoTime();
            System.out.println(method.getName() + " executed in " + (endTime - startTime) + " ns");
        }
    }
}

