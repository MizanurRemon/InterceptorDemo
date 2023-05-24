package org.interceptordemo.Handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler
    public ResponseEntity<?> handleInvalidHeaderFieldException(InvalidHeaderFieldException invalidHeaderFieldException){

        LinkedHashMap<String, Object> body= new LinkedHashMap<>();
        body.put("statusCode", invalidHeaderFieldException.getHttpStatus().value());
        body.put("message", invalidHeaderFieldException.getMessage());

        return new ResponseEntity<>(body,invalidHeaderFieldException.getHttpStatus());
    }
}
