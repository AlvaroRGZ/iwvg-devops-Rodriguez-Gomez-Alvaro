package es.upm.miw.iwvg_devops.code;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FractionTest {
    private Fraction fraction0, fraction1, fraction2;
    @BeforeEach
    void before() {
        fraction0 = new Fraction();
        fraction1 = new Fraction(2, 4);
        fraction2 = new Fraction(3, 2);
    }

    @Test
    void testFractionDefault() {
        assertEquals(1, fraction0.getNumerator());
        assertEquals(1, fraction0.getDenominator());
        assertEquals(1.00, fraction0.decimal());
    }

    @Test
    void testFractionIntInt() {
        assertEquals(2, fraction1.getNumerator());
        assertEquals(4, fraction1.getDenominator());
        assertEquals(0.5, fraction1.decimal());
    }

    @Test
    void testFractionSetters() {
        fraction1.setNumerator(8);
        fraction1.setDenominator(10);
        assertEquals(8, fraction1.getNumerator());
        assertEquals(10, fraction1.getDenominator());
    }

    @Test
    void testFractionToString() {
        assertEquals("Fraction{numerator=2, denominator=4}", fraction1.toString());
    }

    @Test
    void testFractionIsProper() {
        assertEquals(false, fraction0.isProper());
        assertEquals(true, fraction1.isProper());
        assertEquals(false, fraction2.isProper());
    }

    @Test
    void testFractionIsImproper() {
        assertEquals(true, fraction0.isImproper());
        assertEquals(false, fraction1.isImproper());
        assertEquals(true, fraction2.isImproper());
    }

    @Test
    void testFractionIsEquivalent() {
        assertEquals(true, fraction1.isEquivalent(new Fraction(4, 8)));
        assertEquals(false, fraction2.isEquivalent(new Fraction(4, 8)));
    }

    @Test
    void testFractionAdd() {
        Fraction result1 = new Fraction(4, 4);
        Fraction result2 = new Fraction(8, 4);

        assertEquals(true, result1.isEquivalent(fraction1.add(fraction1)));
        assertEquals(true, result2.isEquivalent(fraction1.add(fraction2)));
    }
}
