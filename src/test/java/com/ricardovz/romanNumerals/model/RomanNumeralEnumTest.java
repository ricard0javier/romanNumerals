package com.ricardovz.romanNumerals.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test the {@link RomanNumeralEnum} class
 */
public class RomanNumeralEnumTest {

    @Test
    public void test_DefinedEnums_areAsExpectedByAlgorithm() throws Exception {

        assertEquals(RomanNumeralEnum.values().length, 13);

        assertEquals(RomanNumeralEnum.valueOf("M").getNumber(), 1000);
        assertEquals(RomanNumeralEnum.valueOf("CM").getNumber(), 900);
        assertEquals(RomanNumeralEnum.valueOf("D").getNumber(), 500);
        assertEquals(RomanNumeralEnum.valueOf("CD").getNumber(), 400);
        assertEquals(RomanNumeralEnum.valueOf("C").getNumber(), 100);
        assertEquals(RomanNumeralEnum.valueOf("XC").getNumber(), 90);
        assertEquals(RomanNumeralEnum.valueOf("L").getNumber(), 50);
        assertEquals(RomanNumeralEnum.valueOf("XL").getNumber(), 40);
        assertEquals(RomanNumeralEnum.valueOf("X").getNumber(), 10);
        assertEquals(RomanNumeralEnum.valueOf("IX").getNumber(), 9);
        assertEquals(RomanNumeralEnum.valueOf("V").getNumber(), 5);
        assertEquals(RomanNumeralEnum.valueOf("IV").getNumber(), 4);
        assertEquals(RomanNumeralEnum.valueOf("I").getNumber(), 1);

    }

    @Test
    public void test_DefinedEnums_areInDescendingOrder() throws Exception {

        int previous = 1001;

        for (RomanNumeralEnum romanNumeral : RomanNumeralEnum.values()) {

            int current = romanNumeral.getNumber();

            assertTrue(previous > current);

            previous = current;

        }

    }
}