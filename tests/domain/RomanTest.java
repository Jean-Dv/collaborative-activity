package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The RomanTest class contains unit tests for the Roman class, which is
 * responsible for converting roman numerals to arabic numbers.
 */
public class RomanTest {
    /**
     * Test case for a valid roman numeral.
     * Expects the converted value to be equal to 5.
     */
    @Test
    public void valid() {
        assertEquals(Integer.valueOf(5), Roman.convert("V"));
    }

    /**
     * Test case for an invalid roman numeral.
     * Expects the converted value to be null.
     */
    @Test
    public void invalid() {
        assertEquals(null, Roman.convert("ABC"));
    }

    /**
     * Test case for a basic conversion.
     * Expects the converted value to be equal to 9.
     */
    @Test
    public void basic() {
        assertEquals(Integer.valueOf(9), Roman.convert("IX"));
    }

    /**
     * Test case for a roman numeral with repetitions.
     * Expects the converted value to be equal to 3000.
     */
    @Test
    public void withRepetitions() {
        assertEquals(Integer.valueOf(3000), Roman.convert("MMM"));
    }

    /**
     * Test case for a roman numeral with substraction.
     * Expects the converted value to be equal to 40.
     */
    @Test
    public void withSubstraction() {
        assertEquals(Integer.valueOf(40), Roman.convert("XL"));
    }

    /**
     * Test case for a complex roman numeral.
     * Expects the converted value to be equal to 987.
     */
    @Test
    public void complex() {
        assertEquals(Integer.valueOf(987), Roman.convert("CMLXXXVII"));
    }

    /**
     * Test case for a roman numeral with wronger order.
     * Expects the converted value to be null.
     */
    @Test
    public void withWrongerOrder() {
        assertEquals(null, Roman.convert("XM"));
    }

    /**
     * Test case fro a roman numeral with invalid characters.
     * Expects the converted value to be null.
     */
    @Test
    public void invalidCharacters() {
        assertEquals(null, Roman.convert("ID"));
    }

    /**
     * Test case for a roman numeral with repeated characters (invalid)
     * Expects the converted value to be null.
     */
    @Test
    public void withRepetitionsInvalid() {
        assertEquals(null, Roman.convert("DD"));
    }
}
