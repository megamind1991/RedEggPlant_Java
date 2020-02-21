package com.rep.exception;

public class ChainedExceptionMain {
    public static void main(String[] args) {/* from w w w . j ava 2 s . co m */
        try {
            method1();
        }
        catch (Exception exception) // exceptions thrown from method1
        {
            exception.printStackTrace();

            // obtain the stack-trace information
            StackTraceElement[] traceElements = exception.getStackTrace();

            System.out.printf("%nStack trace from getStackTrace:%n");
            System.out.println("Class\t\tFile\t\t\tLine\tMethod " + traceElements.length);

            // loop through traceElements to get exception description
            for (StackTraceElement element : traceElements) {
                System.out.printf("%s\t", element.getClassName());
                System.out.printf("%s\t", element.getFileName());
                System.out.printf("%s\t", element.getLineNumber());
                System.out.printf("%s%n", element.getMethodName());
            }
        }
    }

    // call method2; throw exceptions back to main
    public static void method1() throws Exception {
        try {
            method2();
        }
        catch (Exception exception) // exception thrown from method2
        {
            throw new Exception("Exception thrown in method1", exception);
        }
    }

    // call method3; throw exceptions back to method1
    public static void method2() throws Exception {
        try {
            method3();
        }
        catch (Exception exception) // exception thrown from method3
        {
            throw new Exception("Exception thrown in method2", exception);
        }
    }

    // throw Exception back to method2
    public static void method3() throws Exception {
        throw new Exception("Exception thrown in method3");
    }
}