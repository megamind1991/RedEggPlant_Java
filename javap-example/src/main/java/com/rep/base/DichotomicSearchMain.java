package com.rep.base;

import java.math.BigDecimal;

public class DichotomicSearchMain {

    static int Dichotomy(int[] array, int left, int right, int key) {
        if (left > right)
            return -1;

        int m = (left + right) / 2;

        if (array[m] == key) {
            return m;
        } else {//from   ww w  . ja  v  a 2 s. co  m
            if (array[m] < key) return Dichotomy(array, m + 1, right, key);
            else return Dichotomy(array, left, m - 1, key);
        }
    }

    static int DichotomicSearch(int[] array, int key) {
        return Dichotomy(array, 0, array.length - 1, key);
    }

    public static void main(String[] args) {
        int[] v = {11, 6, 19, 112, 45, 67, 76, 80, 95};

        System.out.println("Seeking for element 6: Position " + DichotomicSearch(v, 11));
        System.out.println("Seeking for element 80: Position " + DichotomicSearch(v, 80));
        System.out.println("Seeking for element 33: Position " + DichotomicSearch(v, 33));

        int decimalPlaces = 2;
        BigDecimal bd = new BigDecimal("123.277");
        // Truncates the big decimal value.
        bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
        String string = bd.toString();
        System.out.println(string);//w  w w  .  j  a v a2s . co m


        boolean[] pBits = new boolean[]{true, true, false};
        System.out.println(bitsToInt(pBits));
    }


    public static int bitsToInt(boolean[] pBits) {
        int vInt = 0;
        int vIntBit = 0;
        for (int i = pBits.length - 1; i >= 0; i--) {
            System.out.println(1 << vIntBit);
            if (pBits[i]) {
                vInt |= (1 << vIntBit);
            }
            vIntBit++;
        }
        return vInt;
    }
}

