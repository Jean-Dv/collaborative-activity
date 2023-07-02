package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CousingFactorsTest {
    @Test
    public void withOneCousingFactor() {
        assertEquals("13^1", CousingFactors.of(13));
    }

    @Test
    public void withCompoundCousingFactor() {
        assertEquals("3^1*2^3", CousingFactors.of(24));
    }

    @Test
    public void withCompoundCousingFactorAndExponentsRepeat() {
        assertEquals("3^2*2^2", CousingFactors.of(36));
    }

    @Test
    public void withCompoundCousingFactorComplex() {
        assertEquals("7^1*5^1*3^1*2^3", CousingFactors.of(840));
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
    public void withNumberTooBig() {
        assertEquals("137^1*101^1*73^1*11^1*3^2", CousingFactors.of(99999999));
    }
}
