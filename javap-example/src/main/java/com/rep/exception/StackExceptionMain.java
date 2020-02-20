package com.rep.exception;

import java.io.StringWriter;
import java.io.PrintWriter;

public class StackExceptionMain {
    public static void main(String[] args) {
        try {/*ww w .j a  va  2s  .  co  m*/
            m1();
        } catch (MyTwoException e) {
            String str = getStackTrace(e);

            // Print the stack trace to the standard output
            System.out.println(str);
        }
    }

    public static void m1() throws MyTwoException {
        m2();
    }

    public static void m2() throws MyTwoException {
        throw new MyTwoException("Some error has occurred.");
    }

    public static String getStackTrace(Throwable e) {
        StringWriter strWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(strWriter);
        e.printStackTrace(printWriter);

        // Get the stack trace as a string
        String str = strWriter.toString();

        return str;
    }
}

class MyTwoException extends Exception {
    public MyTwoException() {
        super();
    }

    public MyTwoException(String message) {
        super(message);
    }

    public MyTwoException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyTwoException(Throwable cause) {
        super(cause);
    }
}