package com.rep.recursive;

public class RecursiveFactorialClass {

    public static long factorial(long num) {
        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static long feibonacc(long num) {
        if (num == 0 || num == 1) {
            return num;
        } else {
            return feibonacc(num - 1) + feibonacc(num - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(feibonacc(9));
    }
}
