import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstJUnitTest {

    @Test
    void printHello() {
        System.out.print("hello");
    }

    @Test
    void equalsNum() {
        Assertions.assertEquals(12, 12);
    }

    @Test
    void checkIfTrue() {
        Assertions.assertTrue(2 < 1);
    }

    @Test
    void checkIfEqual() {
        Assertions.assertEquals("lala", "lala");
    }

    @Test
    void checkIfUpper() {
        String word = "qwerTY";
        Assertions.assertEquals("QWERTY", word.toUpperCase());
    }

    int checkAdd2Numbers(int num1, int num2) {
        return num1 + num2;
    }

    @Test
    void shouldCheckAdding() {
        Assertions.assertEquals(4, checkAdd2Numbers(2, 2));
    }

    double circleField(double r) {
        return 3.14 * r * r;
    }

    @Test
    void checkIfCircleFieldOk() {
        Assertions.assertEquals(6.28, circleField(2));
    }

    String removeSpaces(String s) {
        return s.toUpperCase().trim();
    }

    @Test
    void shouldCorrectlyModifyString() {
        Assertions.assertEquals("WORDS", removeSpaces(" WoRdS "));
    }
}
