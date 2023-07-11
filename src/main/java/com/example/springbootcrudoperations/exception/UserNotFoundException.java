package com.example.springbootcrudoperations.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException{
    private String  message;
    private HttpStatus  status;

    public UserNotFoundException(String message, HttpStatus httpStatus){
        this.message = message;
        this.status = httpStatus;
    }

    public static UserNotFoundException badRequest(String exeMsg) {
        return new UserNotFoundException(exeMsg, HttpStatus.BAD_REQUEST);
    }
    public static UserNotFoundException internalError(String exeMsg) {
        return new UserNotFoundException(exeMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
