package com.ricardovz.romanNumerals.dto;

import lombok.Data;

/**
 * Represents an error occurred in the system while processing a request
 */
@Data
public class ErrorDTO {

    private String errorMessage;
}
