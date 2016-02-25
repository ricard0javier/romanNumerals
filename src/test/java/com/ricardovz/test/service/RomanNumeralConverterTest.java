package com.ricardovz.test.service;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;

/**
 * Created by ricardo on 25/02/16.
 */
@Slf4j
public class RomanNumeralConverterTest extends TestCase {

    private RomanNumeralConverter target;

    @Override
    public void setUp() throws Exception {

        target = new RomanNumeralConverter();
    }

    @Ignore
    public void testConvertToRomanNumeral() throws Exception {

        for (int i = 1; i < 4000; i++) {

            log.debug("number = {}, numeral = {}", i, target.convertToRomanNumeral(i));

        }

    }
}