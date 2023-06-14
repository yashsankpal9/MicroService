package com.micro.user.service.UserSerivce.Exceptions;

import com.micro.user.service.UserSerivce.Payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExecption.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundExecption rx){
        String message = rx.getMessage();
        ApiResponse res = ApiResponse.builder().msg(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    }
}
