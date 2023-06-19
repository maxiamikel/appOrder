package com.maxi.backapporder.services.exceptions;

public class DataIntegityViolationException  extends RuntimeException{

    public DataIntegityViolationException(String message, Throwable cause){
        super(message, cause);
    }

    public DataIntegityViolationException(String message){
        super(message);
    }

    
}
