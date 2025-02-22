import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DateFormatterTest {

    private DateFormatter dateFormatter;

    @BeforeEach
    public void setup() {
        dateFormatter = new DateFormatter();
    }

    @Test
    public void testValidDateFormat() {
        assertEquals("25-12-2024", dateFormatter.formatDate("2024-12-25"), "Date conversion failed.");
        assertEquals("01-01-2000", dateFormatter.formatDate("2000-01-01"), "Date conversion failed.");
        assertEquals("15-08-1947", dateFormatter.formatDate("1947-08-15"), "Date conversion failed.");
    }

    @Test
    public void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate("12-25-2024"), "Invalid date format should throw an exception.");
        assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate("2024/12/25"), "Invalid date format should throw an exception.");
        assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate("25-12-24"), "Invalid date format should throw an exception.");
    }

    @Test
    public void testEmptyAndNullInput() {
        assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate(""), "Empty input should throw an exception.");
        assertThrows(NullPointerException.class, () -> dateFormatter.formatDate(null), "Null input should throw a NullPointerException.");
    }
}
