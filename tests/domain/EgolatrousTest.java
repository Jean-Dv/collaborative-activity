package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The EgolatrousTest class contains unit tests for the Egolatrous class, which
 * checks if a number is an Egolatrous number.
 */
public class EgolatrousTest {
    /**
     * Test case for a valid simple Egolatrous number.
     * 
     * Expects the result to be true.
     */
    @Test
    public void validSimple() {
        assertEquals(true, Egolatrous.isEgolatrous(153));
    }

    /**
     * Test case for an invalid simple Egolatrous number.
     * 
     * Expects the result to be false.
     */
    @Test
    public void invalidSimple() {
        assertEquals(false, Egolatrous.isEgolatrous(123));
    }

    /**
     * Test clase for a one-digit valid Egolatrous number.
     * 
     * Expects the result to be true.
     */
    @Test
    public void oneDigitValid() {
        assertEquals(true, Egolatrous.isEgolatrous(7));
    }

    /**
     * Test case for a two-digits invalid Egolatrous number.
     * 
     * Expects the result to be false.
     */
    @Test
    public void twoDigitsInvalid() {
        assertEquals(false, Egolatrous.isEgolatrous(45));
    }

    /**
     * Test case for a complex valid Egolatrous number.
     * 
     * Expects the result to be true.
     */
    @Test
    public void complexValid() {
        assertEquals(true, Egolatrous.isEgolatrous(9474));
    }

    /**
     * Test case for a complex invalid Egolatrous number.
     * 
     * Expects the result to be false.
     */
    @Test
    public void complexInvalid() {
        assertEquals(false, Egolatrous.isEgolatrous(1234));
    }

    /**
     * Test case for a negative number.
     * 
     * Expects the result to be false.
     */
    @Test
    public void negativeNumber() {
        assertEquals(false, Egolatrous.isEgolatrous(-9474));
    }
}
