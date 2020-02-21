package com.rep.base;

import java.text.DecimalFormat;
import java.text.ParsePosition;

public class NumberFormatTest {
    private static DecimalFormat formatter = new DecimalFormat();

    public static void main(String[] args) {
        formatNumber("##.##", 12.456);
        formatNumber("##.##", 12.456);
        formatNumber("0000.0000", 123.456);
        formatNumber("#.##", -123.456);

        // Positive and negative number format
        formatNumber("#.##;(#.##)", -123.345);

        // Parse a string to decimal number
        String str = "XY4,123.123";
        String pattern = "#,###.###";
        formatter.applyPattern(pattern);/* from w w w . j a v a2 s.c om */

        // Create a ParsePosition object to specify the first digit of
        // number in string. It is 4 in "XY4,123.983" and its index is 2.
        ParsePosition pp = new ParsePosition(2);

        Number numberObject = formatter.parse(str, pp);

        double value = numberObject.doubleValue();
        System.out.println("Parsed Value is " + value);
    }

    public static void formatNumber(String pattern, double value) {
        // Apply the pattern
        formatter.applyPattern(pattern);

        // Format the number
        String formattedNumber = formatter.format(value);

        System.out.println("Number:" + value + ", Pattern:" + pattern + ", Formatted Number:" + formattedNumber);
    }
}