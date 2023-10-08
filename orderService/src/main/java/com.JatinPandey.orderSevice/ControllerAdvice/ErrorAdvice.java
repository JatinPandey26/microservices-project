package com.JatinPandey.orderSevice.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorAdvice {
    @ExceptionHandler({Error.class})
    public ResponseEntity<ApiResponse> handler(Error error){
        return new ResponseEntity<>(new ApiResponse(error.getMessage(),500), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
