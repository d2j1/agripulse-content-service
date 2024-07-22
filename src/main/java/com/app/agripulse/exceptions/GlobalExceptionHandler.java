package com.app.agripulse.exceptions;

import com.app.agripulse.models.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NoPostFound.class)
    public ResponseEntity<ErrorDetails> noPostFound(NoPostFound ex){
        ErrorDetails errorDetails  = new ErrorDetails(ex.getMessage(), ex.getId());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SomethingWentWrongException.class)
    public ResponseEntity<ErrorDetails> somethingWentWrongException(SomethingWentWrongException ex) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), null);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
