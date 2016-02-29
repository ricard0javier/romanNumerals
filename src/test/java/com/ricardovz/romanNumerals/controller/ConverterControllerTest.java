package com.ricardovz.romanNumerals.controller;

import com.ricardovz.romanNumerals.service.RomanNumeralConverterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests the {@link ConverterControllerTest} class
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
public class ConverterControllerTest {

    public static final String ROMAN_NUMERAL_I = "I";
    public static final String JSON_PATH_TO_ROMAN_NUMERAL = "$.romanNumeral";
    public static final String JSON_PATH_TO_ERROR_MESSAGE = "$.errorMessage";
    public static final int NUMBER_1 = 1;
    public static final int NUMBER_4000 = 4000;
    public static final String ERROR_MESSAGE = "Error message";
    public static final String INVALID_NUMBER = "X";

    @InjectMocks
    private ConverterController target;

    @Mock
    private RomanNumeralConverterService romanNumeralConverterServiceService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(target).build();

    }

    @Test
    public void test_Convert_whenValidNumberIsGiven_thenReturnsExpectedAnswer() throws Exception {

        when(romanNumeralConverterServiceService.convertToRomanNumeral(anyInt()))
                .thenReturn(ROMAN_NUMERAL_I);

        mockMvc.perform(
                get(ConverterController.PATH, NUMBER_1))
                .andExpect(status().isOk())
                .andExpect(jsonPath(JSON_PATH_TO_ROMAN_NUMERAL, equalTo(ROMAN_NUMERAL_I)))
                .andReturn();

    }

    @Test
    public void test_Convert_whenInvalidNumberIsGiven_thenReturnsError() throws Exception {

        mockMvc.perform(
                get(ConverterController.PATH, INVALID_NUMBER))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath(JSON_PATH_TO_ERROR_MESSAGE, not(isEmptyOrNullString())))
                .andReturn();

    }

    @Test
    public void test_ProcessException_whenIllegalArgumentExceptionIsThrownByController_thenParseTo400Error() throws Exception {

        when(romanNumeralConverterServiceService.convertToRomanNumeral(anyInt()))
                .thenThrow(new IllegalArgumentException(ERROR_MESSAGE));

        mockMvc.perform(
                get(ConverterController.PATH, NUMBER_4000))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath(JSON_PATH_TO_ERROR_MESSAGE, equalTo(ERROR_MESSAGE)))
                .andReturn();

    }

    @Test
    public void test_ProcessException_whenNullPointerExceptionIsThrownByController_thenParseTo500Error() throws Exception {

        when(romanNumeralConverterServiceService.convertToRomanNumeral(anyInt()))
                .thenThrow(new NullPointerException());

        mockMvc.perform(
                get(ConverterController.PATH, NUMBER_1))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath(JSON_PATH_TO_ERROR_MESSAGE, equalTo(ConverterController.ERROR_MESSAGE_500)))
                .andReturn();

    }
}