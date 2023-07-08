package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The RemoveExtraSpacesTest class contains unit tests for the RemoveExtraSpaces
 */
public class RemoveExtraSpacesTest {
    /**
     * Test case for a valid string in the beggin.
     * Expects the converted value to be equal to "abc".
     */
    @Test
    public void inBeggin() {
        assertEquals("Hola Mundo", RemoveExtraSpaces.remove("  Hola Mundo"));
    }

    /**
     * Test case for a valid string in the end.
     * Expects the converted value to be equal to "abc".
     */
    @Test
    public void inEnd() {
        assertEquals("Hola Mundo", RemoveExtraSpaces.remove("Hola Mundo"));
    }

    /**
     * Test case for a valid string in the middle.
     * Expects the converted value to be equal to "abc".
     */
    @Test
    public void inMiddle() {
        assertEquals("Hola Mundo", RemoveExtraSpaces.remove("Hola   Mundo"));
    }

    /**
     * Test case for a valid string in all.
     * Expects the converted value to be equal to "abc".
     */
    @Test
    public void inAll() {
        assertEquals("Hola Mundo", RemoveExtraSpaces.remove(" Hola Mundo "));
    }

    /**
     * Test case for a valid string with one string empty.
     * Expects the converted value to be equal to "abc".
     */
    @Test
    public void withStringEmpty() {
        assertEquals("", RemoveExtraSpaces.remove(""));
    }

    /**
     * Test case for a valid string with one space.
     * Expects the converted value to be equal to "Hola Mundo".
     */
    @Test
    public void withOneSpace() {
        assertEquals("Hola Mundo", RemoveExtraSpaces.remove("Hola Mundo"));
    }
}
