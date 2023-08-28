package com.telecom.authenticationservice.exception;

import lombok.Data;

import static com.telecom.authenticationservice.constants.ErrorConstants.CLIENT_ERROR_CODE;

@Data
public class ClientException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public ClientException(String errorMessage) {
        this.errorCode = CLIENT_ERROR_CODE;
        this.errorMessage = errorMessage;
    }
}
