package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The MagicNumbersTest class contains unit tests for the MagicNumbers class,
 * which is responsible for determining if a number is a magic number.
 */
public class MagicNumbersTest {
    /**
     * Test case for a valid magic number.
     * Expects the result to be true.
     */
    @Test
    public void validSimple() {
        assertEquals(true, MagicNumbers.isMagicNumber(495));
    }

    /**
     * Test case for an invalid magic number.
     * Expects the result to be false.
     */
    @Test
    public void invalidSimple() {
        assertEquals(false, MagicNumbers.isMagicNumber(123));
    }

    /**
     * Test case for an invalid magic number.
     * Expects the result to be false.
     */
    @Test
    public void invalidComplex() {
        assertEquals(false, MagicNumbers.isMagicNumber(987654));
    }
}
