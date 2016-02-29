package com.ricardovz.romanNumerals.controller;

import com.ricardovz.romanNumerals.dto.ErrorDTO;
import com.ricardovz.romanNumerals.dto.RomanNumeralDTO;
import com.ricardovz.romanNumerals.service.RomanNumeralConverterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Exposes the Roman Numeral converter functionality via the API
 */
@RestController
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConverterController {

    public static final String PATH = "/convertToRomanNumeral/{numberString}";
    public static final String ERROR_MESSAGE_500 = "Service unavailable, contact the administrator";
    public static final int MAX_NUMBER_CHARACTERS = 4;

    private RomanNumeralConverterService romanNumeralConverterServiceService;

    /**
     * Exposes the endpoint concertToRomanNumeral, it expect the number
     * to be part of the Path
     *
     * @param numberString number that should be between 1 and 3999
     * @return {@link RomanNumeralDTO} instance
     */
    @RequestMapping(PATH)
    public RomanNumeralDTO convert(@PathVariable String numberString) {

        log.info("Converting '{}' into Roman Numeral", numberString);

        // validate the input
        if (numberString == null || numberString.isEmpty()
                || numberString.chars().count() > MAX_NUMBER_CHARACTERS
                || !numberString.chars().allMatch(Character::isDigit)) {

            throw new IllegalArgumentException("The number provided in the path (" + PATH +"), should be between 1 and 3999, limits included");
        }

        int number = Integer.valueOf(numberString);

        String romanNumeral = romanNumeralConverterServiceService.convertToRomanNumeral(number);

        RomanNumeralDTO romanNumeralDTO = new RomanNumeralDTO();
        romanNumeralDTO.setNumber(numberString);
        romanNumeralDTO.setRomanNumeral(romanNumeral);

        return romanNumeralDTO;

    }

    /**
     *Catches all the exceptions and transform them into ErrorDTO messages
     *
     * @param response Http response to be returned
     * @param exception exception to be catch
     * @return {@link ErrorDTO}
     */
    @ExceptionHandler
    public ErrorDTO processException(HttpServletResponse response, Exception exception) {

        log.warn("Exception reached the controller layer", exception);

        // prepare the response
        ErrorDTO errorDTO = new ErrorDTO();

        if (exception instanceof IllegalArgumentException) {
            // returns a 400 error for illegal argument exceptions

            errorDTO.setErrorMessage(exception.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        } else {
            // returns a 500 error for any other exception catch

            errorDTO.setErrorMessage(ERROR_MESSAGE_500);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        }

        return errorDTO;
    }
}
