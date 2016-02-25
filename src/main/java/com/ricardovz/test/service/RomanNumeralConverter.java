package com.ricardovz.test.service;

import com.ricardovz.test.model.RomanNumeralEnum;
import org.springframework.stereotype.Service;

@Service
public class RomanNumeralConverter {


    public String convertToRomanNumeral(int input) {

        StringBuilder resultBuilder = new StringBuilder();

        for (RomanNumeralEnum romanNumeralEnum : RomanNumeralEnum.values()) {

            while (input >= romanNumeralEnum.getNumber()) {

                resultBuilder.append(romanNumeralEnum.toString());

                input -= romanNumeralEnum.getNumber();

            }
        }

        return resultBuilder.toString();
    }
}
