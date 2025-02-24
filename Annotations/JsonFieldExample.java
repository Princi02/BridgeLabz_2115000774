import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String nonSerializedField;

    public User(String username, int age, String nonSerializedField) {
        this.username = username;
        this.age = age;
        this.nonSerializedField = nonSerializedField;
    }
}

class JsonSerializer {
    public static String serialize(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Map<String, String> jsonElements = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonElements.put(annotation.name(), String.valueOf(field.get(obj)));
            }
        }
        StringBuilder jsonString = new StringBuilder("{");
        jsonElements.forEach((key, value) -> 
            jsonString.append("\"").append(key).append("\":\"").append(value).append("\",")
        );
        if (jsonString.length() > 1) {
            jsonString.setLength(jsonString.length() - 1);
        }
        jsonString.append("}");
        return jsonString.toString();
    }
}

public class JsonFieldExample {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Alice", 25, "NotSerialized");
        String json = JsonSerializer.serialize(user);
        System.out.println(json);
    }
}
