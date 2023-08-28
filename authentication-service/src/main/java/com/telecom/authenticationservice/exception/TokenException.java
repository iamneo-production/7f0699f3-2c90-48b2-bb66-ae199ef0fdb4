package com.telecom.authenticationservice.exception;

import lombok.Data;

import static com.telecom.authenticationservice.constants.ErrorConstants.TOKEN_ERROR_CODE;

@Data
public class TokenException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public TokenException(String errorMessage) {
        this.errorCode = TOKEN_ERROR_CODE;
        this.errorMessage = errorMessage;
    }
}
