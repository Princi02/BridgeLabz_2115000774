import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) throws IllegalArgumentException {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() throws IllegalArgumentException {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                field.setAccessible(true);
                try {
                    String value = (String) field.get(this);
                    int maxLength = field.getAnnotation(MaxLength.class).value();
                    if (value.length() > maxLength) {
                        throw new IllegalArgumentException(
                            "Field " + field.getName() + " exceeds max length of " + maxLength
                        );
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

public class MaxLengthExample {
    public static void main(String[] args) {
        try {
            User validUser = new User("JohnDoe");
            System.out.println("Valid user created");
            User invalidUser = new User("ThisNameIsTooLong");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
