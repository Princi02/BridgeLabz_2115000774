import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class UserRegistrationTest {

    private UserRegistration userRegistration;

    @BeforeEach
    public void setup() {
        userRegistration = new UserRegistration();
    }

    @Test
    public void testValidRegistration() {
        String result = userRegistration.registerUser("john_doe", "john@example.com", "Password123");
        assertEquals("User registered successfully!", result, "Valid user registration failed.");
    }

    @Test
    public void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> 
            userRegistration.registerUser("", "john@example.com", "Password123"),
            "Empty username should throw an exception."
        );
        
        assertThrows(IllegalArgumentException.class, () -> 
            userRegistration.registerUser(null, "john@example.com", "Password123"),
            "Null username should throw an exception."
        );
    }

    @Test
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> 
            userRegistration.registerUser("john_doe", "johnexample.com", "Password123"),
            "Invalid email format should throw an exception."
        );
        
        assertThrows(IllegalArgumentException.class, () -> 
            userRegistration.registerUser("john_doe", "john@.com", "Password123"),
            "Invalid email format should throw an exception."
        );
    }

    @Test
    public void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> 
            userRegistration.registerUser("john_doe", "john@example.com", "pass"),
            "Password too short should throw an exception."
        );
        
        assertThrows(IllegalArgumentException.class, () -> 
            userRegistration.registerUser("john_doe", "john@example.com", "password"),
            "Password without uppercase and digits should throw an exception."
        );
        
        assertThrows(IllegalArgumentException.class, () -> 
            userRegistration.registerUser("john_doe", "john@example.com", "PASSWORD123"),
            "Password without lowercase letters should throw an exception."
        );
    }
}
