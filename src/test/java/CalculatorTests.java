import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    @Test
    void checkAdding() {
        Assertions.assertEquals(10, Calculator.add(5, 5));
    }

    @Test
    void checkAddingNeg() {
        Assertions.assertEquals(-20, Calculator.add(-10, -10));
    }

    @Test
    @Disabled("disabled for checkup")
    void checkSubtracting() {
        Assertions.assertEquals(0, Calculator.subtract(1, 5));
    }

    @Test
    void checkSubtractingToZero() {
        Assertions.assertEquals(0, Calculator.subtract(1, 1));
    }

    @Test
    void checkMultiplying() {
        Assertions.assertEquals(10, Calculator.multiply(2, 5));
    }

    @Test
    void checkMultiplyingZero() {
        Assertions.assertEquals(10, Calculator.multiply(0, 5));
    }
}
