package com.ricardovz.romanNumerals.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents all the Roman Numeral values.
 * The order in which they are defined is important. They might be defined in decedent mode
 */
@Getter
@AllArgsConstructor
public enum RomanNumeralEnum {

    M(1000),
    CM(900),
    D(500),
    CD(400),
    C(100),
    XC(90),
    L(50),
    XL(40),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);

    private int number;

}
