package com.rep.base;

import java.text.NumberFormat;
import java.util.Arrays;

public class FloatTest {
    /* ww w. java2 s .co m */
    public static void main(String[] args) {
        // Round a float value to an Integer
        System.out.println(roundFloatToInt(new Float("8.837")));
        System.out.println(roundDoubleToLong(new Double("9.9")));

        Float float1 = new Float("9.6175");
        Float float2 = new Float("7.38126");
        Float float3 = new Float("2347.373");

        System.out.println("-- Using compareTo --");
        System.out.println(float1.compareTo(float3));
        System.out.println(float2.compareTo(float3));
        System.out.println(float1.compareTo(float1));
        System.out.println(float3.compareTo(float2));

        System.out.println("-- Using compare --");
        System.out.println(Float.compare(float1, float3));
        System.out.println(Float.compare(float2, float3));
        System.out.println(Float.compare(float1, float1));
        System.out.println(Float.compare(float3, float2));

        float total = 14000;
        System.out.println("Original investment: $" + total);
        // Inceases by 40 percent the first year
        total = total + (total * .4F);// from w w w. ja v a 2 s.c o m
        System.out.println("After one year: $" + total);
        // Loses $1,500 the second year
        total = total - 1500F;
        System.out.println("After two years: $" + total);
        // Increases by 12 percent the third year
        total = total + (total * .12F);
        System.out.println("After three years: $" + total);

        float number1 = 15;
        float number2 = 6;
        float result = number1 / number2;
        float remainder = number1 % number2;
        System.out.println(number1 + " divided by " + number2);
        System.out.println("\nResult\tRemainder");
        System.out.println(result + "\t" + remainder);

        Float floatOne = new Float(14.78f - 13.78f);
        Float floatTwo = Float.valueOf("1.0");
        Double doubleOne = new Double(1.0);

        int difference = floatOne.compareTo(floatTwo);

        if (difference == 0) {
            System.out.println("floatOne is equal to floatTwo.");
        }
        else if (difference < 0) {
            System.out.println("floatOne is less than floatTwo.");
        }
        else if (difference > 0) {
            System.out.println("floatOne is greater than floatTwo.");
        } /* from w w w .j ava 2s .com */

        System.out.println("floatOne is " + ((floatOne.equals(doubleOne)) ? "equal" : "not equal") + " to doubleOne.");

        // this program requires two
        // arguments on the command line
        if (args.length == 2) {
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue();
            float b = (Float.valueOf(args[1])).floatValue();

            // do some arithmetic
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));
        }
        else {// from w ww .ja va 2 s . co m
            System.out.println("This program " + "requires two command-line arguments.");
        }

        // 1. Construct Float using constructor.
        Float fObj1 = new Float("10.4");
        System.out.println(fObj1);// from www . jav a 2 s . com

        // 2. Use valueOf method of Float class. This method is static.
        String str1 = "1.4";
        Float fObj2 = Float.valueOf(str1);
        System.out.println(fObj2);

        String str2 = "7.9";
        float f = Float.parseFloat(str2);
        System.out.println(f);

        float[] floatArray1 = new float[] {
            9.4f, 3.4f, 5.1f
        };
        float[] floatArray2 = new float[] {
            9.4f, 3.4f, 5.1f
        };
        // w w w . j a v a 2 s. c o m
        boolean blnResult = Arrays.equals(floatArray1, floatArray2);
        System.out.println("Are two float arrays equal ? : " + blnResult);

        float x = 0.1f;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(10);/* from ww w . ja v a2s. c om */

        System.out.println(x);
        System.out.println(nf.format(x));
    }

    /**
     * Rounds a floating-point number to an Integer and returns the result
     *
     * @param myFloat
     * @return
     */
    public static int roundFloatToInt(float myFloat) {
        return Math.round(myFloat);
    }

    /**
     * Rounds a Double value to an Integer and returns the result
     *
     * @param myDouble
     * @return
     */
    public static long roundDoubleToLong(double myDouble) {
        return Math.round(myDouble);
    }
}