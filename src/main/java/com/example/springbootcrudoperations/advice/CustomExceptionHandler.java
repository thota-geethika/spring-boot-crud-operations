package com.example.springbootcrudoperations.advice;

import com.example.springbootcrudoperations.dto.ResponseDto;
import com.example.springbootcrudoperations.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception) {
        ResponseDto responseDto = ResponseDto.builder()
                .status("FAILURE")
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(responseDto,exception.getStatus());
    }
}
