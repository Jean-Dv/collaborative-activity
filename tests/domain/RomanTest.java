package domain;

import domain.Roman;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RomanTest {
    @Test
    public void valid() {
        assertEquals(Integer.valueOf(5), Roman.convert("V"));
    }

    @Test
    public void invalid() {
        assertEquals(null, Roman.convert("ABC"));
    }

    @Test
    public void basic() {
        assertEquals(Integer.valueOf(9), Roman.convert("IX"));
    }

    @Test
    public void withRepetitions() {
        assertEquals(Integer.valueOf(3000), Roman.convert("MMM"));
    }

    @Test
    public void withSubstraction() {
        assertEquals(Integer.valueOf(40), Roman.convert("XL"));
    }

    @Test
    public void complex() {
        assertEquals(Integer.valueOf(987), Roman.convert("CMLXXXVII"));
    }

    @Test
    public void withWrongerOrder() {
        assertEquals(null, "XM");
    }

    @Test
    public void invalidCharacters() {
        assertEquals(null, Roman.convert("ID"));
    }

    @Test
    public void withRepetitionsInvalid() {
        assertEquals(null, Roman.convert("DD"));
    }
}
