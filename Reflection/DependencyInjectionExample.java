package Reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    public void serve() {
        System.out.println("Service is serving...");
    }
}

class Client {
    @Inject
    private Service service;

    public void doWork() {
        service.serve();
    }
}

class DependencyInjector {
    public static void initialize(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.set(obj, dependency);
            }
        }
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        DependencyInjector.initialize(client);
        client.doWork();
    }
}

