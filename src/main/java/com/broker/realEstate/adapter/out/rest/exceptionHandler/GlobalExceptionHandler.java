package com.broker.realEstate.adapter.out.rest.exceptionHandler;

import com.broker.realEstate.domain.exception.ConflictException;
import com.broker.realEstate.domain.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorModel> handleValidationErrors(MethodArgumentNotValidException ex)
    {
        ErrorModel errorModel = new ErrorModel(HttpStatus.BAD_REQUEST.value(), ex.getBindingResult().getFieldError().getDefaultMessage());
        return  new ResponseEntity<>(errorModel,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorModel> handleConflictException(ConflictException ex)
    {   ErrorModel errorModel = new ErrorModel(HttpStatus.CONFLICT.value(),ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.CONFLICT);
    }
}
