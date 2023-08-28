<<<<<<< HEAD
package com.telecom.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ResponseDto<T> {
    private String status;
    private T data;
    private List<ErrorDto> errors;

    public static <T> ResponseDto<T> forSuccess(T data) {
        return new ResponseDto<>("SUCCESS", data, null);
    }

    public static ResponseDto<Object> forError(List<ErrorDto> errors) {
        return new ResponseDto<>("ERROR", null, errors);
    }

}
=======
package com.telecom.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ResponseDto<T> {
    private String status;
    private T data;
    private List<ErrorDto> errors;

    public static <T> ResponseDto<T> forSuccess(T data) {
        return new ResponseDto<>("SUCCESS", data, null);
    }

    public static ResponseDto<Object> forError(List<ErrorDto> errors) {
        return new ResponseDto<>("ERROR", null, errors);
    }

}
>>>>>>> 1154ea08bf9a1965144d2ac50ca7de90386cda8e
