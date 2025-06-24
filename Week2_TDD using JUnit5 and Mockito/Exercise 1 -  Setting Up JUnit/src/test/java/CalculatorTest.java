import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd_case01() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testAdd_case02() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.add(7, 3));
    }

    @Test
    public void testAdd_case03() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.add(-2, 3));
    }
}
