import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    public void setup() {
        validator = new PasswordValidator();
    }

    @Test
    public void testValidPassword() {
        assertTrue(validator.isValid("Password1"), "Password should be valid");
    }

    @Test
    public void testShortPassword() {
        assertFalse(validator.isValid("Pass1"), "Password is too short");
    }

    @Test
    public void testNoUppercasePassword() {
        assertFalse(validator.isValid("password1"), "Password lacks an uppercase letter");
    }

    @Test
    public void testNoDigitPassword() {
        assertFalse(validator.isValid("Password"), "Password lacks a digit");
    }

    @Test
    public void testNullPassword() {
        assertFalse(validator.isValid(null), "Password should not be null");
    }

    @Test
    public void testEmptyPassword() {
        assertFalse(validator.isValid(""), "Password should not be empty");
    }
}
