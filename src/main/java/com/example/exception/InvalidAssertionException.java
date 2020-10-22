package com.example.exception;

public class InvalidAssertionException extends Throwable {
    public InvalidAssertionException() {
        super();
    }

    public InvalidAssertionException(Exception e) {
        super(e);
    }
}
