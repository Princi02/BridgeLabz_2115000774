import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    StringUtils stringUtils = new StringUtils();

    @Test
    public void testReverse() {
        assertEquals("olleH", stringUtils.reverse("Hello"));
        assertEquals("", stringUtils.reverse(""));
        assertEquals(null, stringUtils.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertTrue(stringUtils.isPalindrome("Racecar"));
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("", stringUtils.toUpperCase(""));
        assertEquals(null, stringUtils.toUpperCase(null));
    }
}
