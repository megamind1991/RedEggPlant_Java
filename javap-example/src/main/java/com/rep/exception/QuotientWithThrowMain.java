package com.rep.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuotientWithThrowMain {
    // demonstrates throwing an exception when a divide-by-zero occurs
    public static int quotient(int numerator, int denominator)
            throws ArithmeticException
    {/*from  w  ww  .j a  v  a  2s.  c  o m*/
        return numerator / denominator; // possible division by zero
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true; // determines if more input is needed

        do {
            try // read two numbers and calculate quotient
            {
                System.out.println("Please enter an integer numerator: ");
                int numerator = 1;
                System.out.println("Please enter an integer denominator: ");
                int denominator = 0;

                int result = quotient(numerator, denominator);
                System.out.printf("%nResult: %d / %d = %d%n", numerator,
                        denominator, result);
                continueLoop = false; // input successful; end looping
            } catch (InputMismatchException inputMismatchException) {
                System.err.printf("%nException: %s%n",
                        inputMismatchException);
                scanner.nextLine(); // discard input so user can try again
                System.out.printf(
                        "You must enter integers. Please try again.%n%n");
            } catch (ArithmeticException arithmeticException) {
                System.err.printf("%nException: %s%n", arithmeticException);
                System.out.printf(
                        "Zero is an invalid denominator. Please try again.%n%n");
            }
        } while (false);
    }
}