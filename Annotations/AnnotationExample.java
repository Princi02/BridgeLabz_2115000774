import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value();
}

class MyClass {
    @MyAnnotation(value = "Hello, Annotation!")
    public void myMethod() {
        System.out.println("Executing myMethod()");
    }
}

public class AnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = MyClass.class.getMethod("myMethod");
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation Value: " + annotation.value());
        }
    }
}
