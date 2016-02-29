package com.ricardovz.romanNumerals.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests teh class {@link RomanNumeralConverterService}
 */
@Slf4j
public class RomanNumeralConverterServiceTest {

    public static final int NUMBER_TEN = 10;
    public static final int NUMBER_ZERO = 0;
    public static final String ROMAN_NUMERAL_X = "X";

    private RomanNumeralConverterService target;


    @Before
    public void setUp() throws Exception {

        target = new RomanNumeralConverterService();
    }

    @Test
    public void test_ConvertToRomanNumeral_whenValidNumberIsGiven_ReturnsExpected() {

        String result = target.convertToRomanNumeral(NUMBER_TEN);

        assertEquals(ROMAN_NUMERAL_X, result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ConvertToRomanNumeral_whenInValidNumberIsGiven_ThrowsIllegalArgumentException() {

        target.convertToRomanNumeral(NUMBER_ZERO);

    }
}