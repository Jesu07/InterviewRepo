package com.example.demo.exception;

public class InvalidBookException extends Exception {

    public InvalidBookException(String s) {
    }

    public Exception InvalidBookException(String s) {
        throw new RuntimeException(s);
    }
}
