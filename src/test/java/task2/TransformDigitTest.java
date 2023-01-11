package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransformDigitTest {

    @Test
    void transformExampleTest() {
        int inputValue = 998;
        int expectedValue = 10109;
        assertEquals(expectedValue, TransformDigit.transform(inputValue));
    }

    @Test
    void transform111Test() {
        int inputValue = 123;
        int expectedValue = 234;
        assertEquals(expectedValue, TransformDigit.transform(inputValue));
    }

    @Test
    void transform0Test() {
        int inputValue = 0;
        int expectedValue = 1;
        assertEquals(expectedValue, TransformDigit.transform(inputValue));
    }

}
