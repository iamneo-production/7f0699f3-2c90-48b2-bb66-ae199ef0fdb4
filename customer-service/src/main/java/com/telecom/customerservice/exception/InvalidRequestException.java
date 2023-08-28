<<<<<<< HEAD
package com.telecom.customerservice.exception;

import lombok.Data;

import static com.telecom.customerservice.constants.ErrorConstants.INVALID_REQUEST_ERROR_CODE;

@Data
public class InvalidRequestException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public InvalidRequestException(String errorMessage) {
        this.errorCode = INVALID_REQUEST_ERROR_CODE;
        this.errorMessage = errorMessage;
    }
}
=======
package com.telecom.customerservice.exception;

import lombok.Data;

import static com.telecom.customerservice.constants.ErrorConstants.INVALID_REQUEST_ERROR_CODE;

@Data
public class InvalidRequestException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public InvalidRequestException(String errorMessage) {
        this.errorCode = INVALID_REQUEST_ERROR_CODE;
        this.errorMessage = errorMessage;
    }
}
>>>>>>> 1154ea08bf9a1965144d2ac50ca7de90386cda8e
