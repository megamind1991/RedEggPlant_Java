package com.rep.innerclass;

/**
 * 非静态内部类 不能使用静态元素
 */
public class ProblemSolved {
    String s;// from w ww. jav a 2s .c o m

    class Inner {
        void testMethod() {
            s = "Set from Inner";
        }
    }
}