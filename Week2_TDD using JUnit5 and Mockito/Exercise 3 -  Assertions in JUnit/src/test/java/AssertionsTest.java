import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertEquals() {
        // Assert equals (checks if two values are equal)
        assertEquals(5, 2 + 3, "2 + 3 should equal 5");
    }

    @Test
    public void testAssertTrue() {
        // Assert true (checks if condition is true)
        assertTrue(5 > 3, "5 should be greater than 3");
    }

    @Test
    public void testAssertFalse() {
        // Assert false (checks if condition is false)
        assertFalse(5 < 3, "5 should not be less than 3");
    }

    @Test
    public void testAssertNull() {
        // Assert null (checks if object is null)
        assertNull(null, "Object should be null");
    }

    @Test
    public void testAssertNotNull() {
        // Assert not null (checks if object is not null)
        assertNotNull(new Object(), "Object should not be null");
    }

    @Test
    public void testAssertSame() {
        // Assert same (checks if two objects are the same instance)
        String str = "Hello";
        assertSame(str, str, "Should be the same object");
    }

    @Test
    public void testAssertNotSame() {
        // Assert not same (checks if two objects are not the same instance)
        assertNotSame(new String("Hello"), new String("Hello"), "Should be different objects");
    }

    @Test
    public void testAssertArrayEquals() {
        // Assert array equals (compares two arrays for equality)
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    public void testAssertThrows() {
        // Assert throws (checks if expected exception is thrown)
        assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0;
        }, "Division by zero should throw ArithmeticException");
    }
}