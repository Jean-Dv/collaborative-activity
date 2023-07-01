package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CousingFactorsTest {
    @Test
    public void withOneCousingFactor() {
        assertEquals("13¹", CousingFactors.of(13));
    }

    @Test
    public void withCompoundCousingFactor() {
        assertEquals("3¹*2³", CousingFactors.of(24));
    }

    @Test
    public void withCompoundCousingFactorAndExponentsRepeat() {
        assertEquals("3²*2²", CousingFactors.of(36))
    }

    @Test
    public void withCompoundCousingFactorComplex() {
        assertEquals("7¹*5¹*3¹*2³", CousingFactors.of(840));
    }

    @Test
    public void withNumberOne() {
        assertEquals(null, CousingFactors.of(1));
    }

    @Test
    public void withNegativeNumber() {
        assertEquals(null, CousingFactors.of(-15));
    }

    @Test
    public void withZero() {
        assertEquals(null, CousingFactors.of(0));
    }

    @Test
    public void withDecimalNumber() {
        assertEquals(null, CousingFactors.of(3.14));
    }

    @Test
    void withNumberTooBig() {
        assertEquals("4649¹*239¹*11¹*3²", CousingFactors.of(99999999));
    }
}
