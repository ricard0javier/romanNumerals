package com.ricardovz.test.controller;

import com.ricardovz.test.service.RomanNumeralConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ricardo on 25/02/16.
 */
@RestController
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConverterController {

    private RomanNumeralConverter romanNumeralConverter;

    @RequestMapping("convert/{number}")
    public String convert(@PathVariable Integer number) {

        return romanNumeralConverter.convertToRomanNumeral(number);

    }
}
