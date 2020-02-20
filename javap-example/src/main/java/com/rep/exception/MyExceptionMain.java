package com.rep.exception;

public class MyExceptionMain {
    public void m1() throws MyException {
        // Code for m1() body goes here
        try {// www  .j ava  2  s  .c  o m
            // Code for the try block goes here
            throw new MyException();
        } catch (MyException e) {
            // Code for the catch block goes here
        }

    }

}

class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}