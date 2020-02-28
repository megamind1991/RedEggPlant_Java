package com.rep.statictest;

/**
 *
 */
public class StaticVariableMain {
    static int nbfunccalls = 0;

    static int square(int x) {
        nbfunccalls++;// from w ww .j a va2 s. c o m
        return x * x;
    }

    static boolean isOdd(int p) {
        nbfunccalls++;
        if ((p % 2) == 0)
            return false;
        else
            return true;
    }

    static double distance(double x, double y) {
        double result;
        nbfunccalls++;
        if (x > y)
            result = x - y;
        else
            result = y - x;
        return result;
    }

    static void display(double x, double y) {
        nbfunccalls++;
        System.out.println("(" + x + "," + y + ")");
    }

    static double ff(double xx) {
        double xx1 = 0.0;
        return xx1;
    }

    public static void main(String[] args) {
        display(3, 2);
        display(square(2), distance(5, 9));

        int p = 123124345;
        if (isOdd(p))
            System.out.println("p is odd");
        else
            System.out.println("p is even");

        System.out.println("Total number of function calls:" + nbfunccalls);
    }
}