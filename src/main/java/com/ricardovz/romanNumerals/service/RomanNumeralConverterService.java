package com.ricardovz.romanNumerals.service;

import com.ricardovz.romanNumerals.model.RomanNumeralEnum;
import org.springframework.stereotype.Service;

@Service
public class RomanNumeralConverterService {

    public static final int LOWEST_NUMBER_PERMITTED = 1;
    public static final int HIGHEST_NUMBER_PERMITTED = 3999;

    /**
     * Converts a number into Roman Numeral.
     * If the number is lower than 1  or greater than 3999 an empty String is returned
     *
     * @param number natural number to be converted
     * @return Roman Numeral representation of the given number
     */
    public String convertToRomanNumeral(int number) {

        // validate the number
        if (number < LOWEST_NUMBER_PERMITTED || number > HIGHEST_NUMBER_PERMITTED) {

            throw new IllegalArgumentException("Number should be between 1 and 3999, extremes included");
        }


        StringBuilder romanNumeralBuilder = new StringBuilder();

        // Iterate the RomanNumeralEnum in order to build the result
        for (RomanNumeralEnum currentNumeral : RomanNumeralEnum.values()) {

            // while the number is greater than the current roman numeral, extract
            // its value and add the Roman Numeral letter to the result
            while (number >= currentNumeral.getNumber()) {

                // add the Roman Numeral letter to the result
                romanNumeralBuilder.append(currentNumeral.toString());

                // subtract the Roman Numeral and continue the loop
                number -= currentNumeral.getNumber();

            }
        }

        return romanNumeralBuilder.toString();
    }
}
