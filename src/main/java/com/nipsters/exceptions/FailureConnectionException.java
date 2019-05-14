package com.nipsters.exceptions;

public class FailureConnectionException extends Exception {

    private static final long serialVersionUID = 1L;

    public FailureConnectionException(){
        super("Fail to connect!");
    }
    
}