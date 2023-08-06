package com.maxi.backapporder.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.maxi.backapporder.services.exceptions.DataIntegityViolationException;
import com.maxi.backapporder.services.exceptions.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> noSuchResponseEntity(NoSuchElementException e){
        StandardError err = new StandardError(System.currentTimeMillis(), e.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    //MethodArgumentTypeMismatchException
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandardError> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        StandardError err = new StandardError(System.currentTimeMillis(), "O ID informado é inválido. Informe o ID sem letre e nem caracter especial!", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    //DataIntegityViolationException
    @ExceptionHandler(DataIntegityViolationException.class)
    public ResponseEntity<StandardError> dataIntegityViolationException(DataIntegityViolationException e){
        StandardError err = new StandardError(System.currentTimeMillis(), e.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    //MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e){
        StandardError err = new StandardError(System.currentTimeMillis(), e.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    //ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> constraintViolationException(ConstraintViolationException e){
        StandardError err = new StandardError(System.currentTimeMillis(), e.getMessage(), HttpStatus.NO_CONTENT.value());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(err);
    }
}


