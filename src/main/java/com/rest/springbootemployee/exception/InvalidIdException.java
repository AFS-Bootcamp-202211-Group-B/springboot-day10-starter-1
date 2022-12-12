package com.rest.springbootemployee.exception;

public class InvalidIdException extends RuntimeException{
    public InvalidIdException() {
        super("The Id is invalid");
    }
}
