package com.rep.innerclass;

/**
 * 静态内部类内才能使用 静态方法
 */
class Problem {// ww w . jav a2 s .c om
    static String s;

    static class Inner {
        void testMethod() {
            s = "Set from Inner";
        }
    }
}