package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RailFenceCipherTest {

    @Test
    void encodeExampleTest() {
        int number = 3;
        String inputValue = "WEAREDISCOVEREDFLEEATONCE";
        String expectedValue = "WECRLTEERDSOEEFEAOCAIVDEN";
        assertEquals(expectedValue, RailFenceCipher.encode(inputValue, number));
    }

    @Test
    void decodeExampleTest() {
        int number = 3;
        String inputValue = "WECRLTEERDSOEEFEAOCAIVDEN";
        String expectedValue = "WEAREDISCOVEREDFLEEATONCE";
        assertEquals(expectedValue, RailFenceCipher.decode(inputValue, number));
    }

    @Test
    void encodeTarasTest() {
        int number = 3;
        String inputValue = "TARAS";
        String expectedValue = "TSAAR";
        assertEquals(expectedValue, RailFenceCipher.encode(inputValue, number));
    }

    @Test
    void decodeTarasTest() {
        int number = 3;
        String inputValue = "TSAAR";
        String expectedValue = "TARAS";
        assertEquals(expectedValue, RailFenceCipher.decode(inputValue, number));
    }

}
