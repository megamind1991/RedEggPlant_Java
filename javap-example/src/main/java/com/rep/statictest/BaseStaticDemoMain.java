package com.rep.statictest;

/**
 * 普通的static类
 */
public class BaseStaticDemoMain {

    static int square(int x) {
        return x * x;
    }/* from w w w. j a v a2 s . c o m */

    static boolean isOdd(int p) {
        if ((p % 2) == 0)
            return false;
        else
            return true;
    }

    static double distance(double x, double y) {
        if (x > y)
            return x - y;
        else
            return y - x;
    }

    static void display(double x, double y) {
        System.out.println("(" + x + "," + y + ")");
        return; // return void
    }

    public static void main(String[] args) {
        display(3, 2);
        display(square(2), distance(5, 9));

        int p = 123124345;
        if (isOdd(p))
            System.out.println("p is odd");
        else
            System.out.println("p is even");
    }
}