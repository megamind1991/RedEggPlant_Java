package com.rep.reflection.selfArray;

import java.lang.reflect.Array;

/**
 *
 * 反射创建多维数组
 *
 */
public class CreateMatrix {
    public static void main(String[] args) {
        // 反射一个二维的数组
        Object twoMatrix = Array.newInstance(int.class, 2, 2);
        Object one = Array.get(twoMatrix, 0);
        Object two = Array.get(twoMatrix, 1);
        Array.set(one, 0, 1);
        Array.set(one, 1, 2);
        Array.set(two, 0, 3);
        Array.set(two, 1, 4);
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < 2; i1++) {
                System.out.println(((int[][]) twoMatrix)[i][i1]);
            }
        }
    }
}
