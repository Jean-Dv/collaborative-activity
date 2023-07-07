package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The DateFormatTest class contains unit tests for the DateFormat class, which
 * is responsible for converting dates from the format DD/MM/YYYY to the format
 * DD de MONTH de YYYY.
 */
public class DateFormatTest {
    /**
     * Test case for a valid date.
     * Expects the converted value to be equal to 15 de Diciembre de 2022.
     */
    @Test
    public void validFormat() {
        assertEquals("15 de Diciembre de 2022", DateFormat.format("15/12/2022"));
    }

    /**
     * Test case for a invalid date because month out range.
     * Expects the converted value to be null.
     */
    @Test
    public void monthOutRange() {
        assertEquals(null, DateFormat.format("25/13/2024"));
    }

    /**
     * Test case for a invalid date because day out range.
     * Expects the converted value to be null.
     */
    @Test
    public void dayOutRange() {
        assertEquals(null, DateFormat.format("31/02/2023"));
    }

    /**
     * Test case for a invalid format YYYY/MM/DD.
     * Expects the converted value to be null.
     */
    @Test
    public void invalidFormat() {
        assertEquals(null, DateFormat.format("2022/12/15"));
    }

    /**
     * Test case for a invalid date with negative value.
     * Expects the converted value to be null.
     */
    @Test
    public void invalidDateWithNegativeValue() {
        assertEquals(null, DateFormat.format("-15/12/2022"));
    }

    /**
     * Test case for a invalid date with invalid characters.
     * Expects the converted value to be null.
     */
    @Test
    public void invalidCharacters() {
        assertEquals(null, DateFormat.format("30/abril/2019"));
    }

    /**
     * Test case for a invalid date with invalid separators.
     * Expects the converted value to be null.
     */
    @Test
    public void invalidSeparators() {
        assertEquals(null, DateFormat.format("30-abril-2019"));
    }
}
