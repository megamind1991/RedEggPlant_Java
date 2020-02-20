package com.rep.exception;

import java.util.Scanner;

public class QuotientWithoutThrowMain {
    // demonstrates throwing an exception when a divide-by-zero occurs
    public static int quotient(int numerator, int denominator) {/*www  .  j av a  2s  .  c  o  m*/
        return numerator / denominator; // possible division by zero
    }

    public static void main(String[] args) {

        System.out.print("Please enter an integer numerator: ");
        int numerator = 1;
        int denominator = 0;

        int result = quotient(numerator, denominator);
        System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);
    }
}