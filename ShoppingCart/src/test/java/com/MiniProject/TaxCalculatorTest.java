package com.MiniProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaxCalculatorTest {
    @Test
    void testTaxForTaxableState() {
        assertEquals(6.00, TaxCalculator.calculateTax(100, "IL"), 0.01);
        assertEquals(6.00, TaxCalculator.calculateTax(100, "CA"), 0.01);
    }

    @Test
    void testTaxForNonTaxableState() {
        assertEquals(0.00, TaxCalculator.calculateTax(100, "TX"), 0.01);
    }
}
