package com.telecom.authenticationservice.exception;

import lombok.Data;

import static com.telecom.authenticationservice.constants.ErrorConstants.INVALID_REQUEST_ERROR_CODE;

@Data
public class InvalidRequestException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public InvalidRequestException(String errorMessage) {
        this.errorCode = INVALID_REQUEST_ERROR_CODE;
        this.errorMessage = errorMessage;
    }
}
