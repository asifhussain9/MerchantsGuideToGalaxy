package com.example.exception;

public class InvalidAssertionException extends Exception {
    public InvalidAssertionException() {
        super();
    }

    public InvalidAssertionException(Exception e) {
        super(e);
    }
}
