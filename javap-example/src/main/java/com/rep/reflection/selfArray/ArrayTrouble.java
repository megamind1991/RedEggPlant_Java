package com.rep.reflection.selfArray;

import java.lang.reflect.Array;

public class ArrayTrouble {
    public static void main(String[] args) {
        Object o = Array.newInstance(int.class, 0);
        int[] o1 = (int[]) o;
        int[] o2 = new int[0];
        System.out.println(o1.length);
        System.out.println(o2.length);
        System.out.println(o1[0]);


    }
}
