package com.rep.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class SaveExceptionStacktracetoStringMain {
    public static void main(String args[]) {

        try {/*from   w  w w  . j  a  va2  s .  c  o  m*/
            // this will throw NumberFormatException
            Integer.parseInt("Not a number");

        } catch (NumberFormatException e) {

            StringWriter sWriter = new StringWriter();

            PrintWriter pWriter = new PrintWriter(sWriter);

            e.printStackTrace(pWriter);

            String strStackTrace = sWriter.toString();

            System.out.println("Stacktrace converted to String: " + strStackTrace);
        }
    }
}