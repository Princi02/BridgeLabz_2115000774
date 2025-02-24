package Reflection;

import java.lang.reflect.Field;
import java.util.Map;

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(instance, entry.getValue());
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = Map.of("name", "Alice", "age", 25);
        User user = toObject(User.class, properties);
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
    }
}

