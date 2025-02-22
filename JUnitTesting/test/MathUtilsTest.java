import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

    @Test
    public void testDivide() {
        assertEquals(2, mathUtils.divide(6, 3));
        assertEquals(-3, mathUtils.divide(9, -3));
        assertEquals(0, mathUtils.divide(0, 1));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(6, 0));
    }
}
