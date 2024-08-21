package com.example.demo.exception;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(String s) {
    }

    public Exception BookNotFoundException(String s) {
        return new RuntimeException(s);
    }
}
