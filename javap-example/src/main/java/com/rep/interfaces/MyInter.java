package com.rep.interfaces;

/**
 * java 9 接口内可以定义私有方法，并且可以被接口的其他方法调用 不可以被任何实现了接口的类对象所调用
 */
interface MyInter {
    /* from w ww.j av a 2 s . c o m */
    public default double a(double length, double width, double depth) {
        return myMethod(length, width, depth);
    }

    public default double b(double length, double width, double shallowDepth, double middleDepth, double deepDepth) {
        return myMethod(length, width, 6);
    }

    /**
     * Standard square or rectangular volume calculation.
     */
    static double myMethod(double length, double width, double depth) {
        return length * width * depth * 7.5;
    }
}
