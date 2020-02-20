package com.rep.exception;

public class SimpleException extends Exception {
    public SimpleException () {}

    public SimpleException (String message) {
        super (message);
    }
}