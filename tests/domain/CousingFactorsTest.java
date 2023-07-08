package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * The CousingFactorTest is one clase for the unit test.
 */
public class CousingFactorsTest {
    /*
    *Check the case when the number has only one cousing factor.
    *Expects that return be equal to 13^1
    */
    @Test
    public void withOneCousingFactor() {
        assertEquals("13^1", CousingFactors.of(13));
    }
    /* 
    *Check the case when the number has several cousing factors .
    *Expects that return be equal to 3^1*2^3
    */
    @Test
    public void withCompoundCousingFactor() {
        assertEquals("3^1*2^3", CousingFactors.of(24));
    }
    /* 
    *Check the case when the number has several cousing factors and teh exponents are duplicated.
    *Expects that return be equal to 3^2*2^2"
    */
    @Test
    public void withCompoundCousingFactorAndExponentsRepeat() {
        assertEquals("3^2*2^2", CousingFactors.of(36));
    }
    /* 
    *Check the case when the the numebr is a large number with multiple cousing factors.
    *Except that return be equal to 7^1*5^1*3^1*2^3
    */
    @Test
    public void withCompoundCousingFactorComplex() {
        assertEquals("7^1*5^1*3^1*2^3", CousingFactors.of(840));
    }
    /* 
    *Check the case when the number is one.
    *Expects that return be equal to null"
    */
    @Test
    public void withNumberOne() {
        assertEquals(null, CousingFactors.of(1));
    }
    /* 
    *Check the case when number is a negative number.
    *Expects that return be equal to null"
    */
    @Test
    public void withNegativeNumber() {
        assertEquals(null, CousingFactors.of(-15));
    }
    /* 
    *Check the case when the number is zero.
    *Expects that return be equal to null"
    */
    @Test
    public void withZero() {
        assertEquals(null, CousingFactors.of(0));
    }
    /* 
    *Check the case when the number is too big.
    *Expects that return be equal to 137^1*101^1*73^1*11^1*3^"
    */
    @Test
    public void withNumberTooBig() {
        assertEquals("137^1*101^1*73^1*11^1*3^2", CousingFactors.of(99999999));
    }
}
