package com.rep.methodparam;

public class MethodPassConstantValueClass {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        System.out.println("a = " + a + " b= " + b);
        MethodPassConstantValueClass.test(1, 2);
        System.out.println("a = " + a + " b= " + b);

        String h1 = "hi";
        System.out.println(h1);
        MethodPassConstantValueClass.testString(h1);
        System.out.println(h1);

        System.out.println(getMaxNum(1, 3, 9, 10));
        System.out.println(getMaxNum(7, 1, 3));
        System.out.println(getMaxNum(-1, -2, 3));
    }

    public static void test(final int x, int y) {
        System.out.println("X = " + x + " Y= " + y);
        y = 3;
        System.out.println("X = " + x + " Y= " + y);
    }

    public static void testString(String xx) {
        System.out.println(xx);
        xx = xx + "there";
        System.out.println(xx);
    }

    public static int getMaxNum(final int n1, final int n2, int... nums) {
        int max = (n1 > n2 ? n1 : n2);

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
