package com.rep.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntTest {

    public static void main(String[] args) {
        int n = 2147483647; // 2^31-1;
        int nval = n + 1;
        System.out.println("If n=" + n + " then n+1=" + nval);

        long m = 9223372036854775807L;
        long mval = m + 1;
        System.out.println("If m=" + m + " then m+1=" + mval);

        System.out.print("Enter some text and press Enter key: ");
        char c = readChar();
        System.out.println("First character you entered is: " + c);

        // from ww w . ja v a2 s . c o m
        int i = 27;

        String strOctalNumber = Integer.toOctalString(i);

        System.out.println("Convert decimal number to octal number example");
        System.out.println("Octal value of " + i + " is " + strOctalNumber);

        int width = 0;
        int length = 0;

        try {// from w w w.j a v a2 s . com
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of a rectangle");
            length = Integer.parseInt(br.readLine());
            System.out.println("Please enter width of a rectangle");
            width = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException ne) {
            System.out.println("Invalid value" + ne);
            System.exit(0);
        }
        catch (IOException ioe) {
            System.out.println("IO Error :" + ioe);
            System.exit(0);
        }

        int area = length * width;

        System.out.println("Area of a rectangle is " + area);

        /* from ww w . j ava 2s . com */
        i = 32;

        String strHexNumber = Integer.toHexString(i);

        System.out.println("Convert decimal number to hexadecimal number example");
        System.out.println("Hexadecimal value of " + i + " is " + strHexNumber);

        i = 56;

        String strBinaryNumber = Integer.toBinaryString(i);

        System.out.println("Convert decimal number to binary number example");
        System.out.println("Binary value of " + i + " is " + strBinaryNumber);

        strOctalNumber = "33";
        int decimalNumber = Integer.parseInt(strOctalNumber, 8);

        // declare string containing hexadecimal number
        strHexNumber = "20";

        decimalNumber = Integer.parseInt(strHexNumber, 16);
        System.out.println("Hexadecimal number converted to decimal number");
        System.out.println("Decimal number is : " + decimalNumber);

        int a = 1000000000;
        System.out.println(a);/* from ww w.j a v a2 s. co m */
        a += 1000000000;
        System.out.println(a);
        a += 1000000000;
        System.out.println(a);
        a += 1000000000;
        System.out.println(a);

        // When you divide two intvalues, the result is an integer value
        a = 21;
        int b = 6;
        double answer = a / b; // answer = 3.0

        System.out.println(answer);// w ww . j a va 2 s .c o m

    }/* from w ww . ja v a2 s . c om */

    public static char readChar() {
        char c = '\u0000';
        int input = 0;
        try {
            input = System.in.read();
            if (input != -1) {
                c = (char) input;
            }
        }
        catch (IOException e) {
            System.out.print("IOException occurred while reading input.");
        }
        return c;
    }

}