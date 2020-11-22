package com.rep.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericPrintClass {
    /**
     * @Description : 功能说明<br>
     * @author : 大刘
     * @param args 参数
     * @taskId <br>
     * @return : 无
     */
    public static void main(final String[] args) {
        Double[] dd = {
            1.1d, 1.2d
        };
        Character[] cc = {
            'a', 'b', 'c', 'd'
        };
        printAnyArray(dd);
        printAnyArray(cc);
    }

    /**
     * @Description : 这边的T 需要报装类型的类型 不可以是基本类型<br>
     * @author : 大刘
     * @Param null
     * @taskId <br>
     * @return :
     */
    public static <T> void printAnyArray(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }

    public static <T extends Comparable<T>> void getMaxValue(T a, T b, T c) {

    }

    public static void sumAnyNumber(ArrayList<? extends Number> numberList) {
        for (Number number : numberList) {
            // ..
        }
    }

    /**
      * @Description : 功能说明<br>
      * @author : 大刘
      * @param i i
      * @taskId <br>
      * @return : void
      */
    void foo(final List<?> i) {
        // 泛型通配符用于传递
        for (Object o : i) {
            // 通配符不知道类型 所以只能是object
        }
        fooHelper(i);
        // from w ww. java 2 s. co m
    }

    private <T> void fooHelper(List<T> l) {
        // 直接指定类型的泛型 可以使用里面具体的值进行处理
        l.set(0, l.get(0));
    }
}
