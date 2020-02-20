package com.rep.oop;

public class VectorAdditionMain {

    static int[] VectorAddition(int[] u, int[] v) {
        int[] result = new int[u.length];

        for (int i = 0; i < u.length; i++)
            result[i] = u[i] + v[i];/*from  w w  w .  j  a  v  a2s .  c  o m*/

        return result;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3};
        int[] y = {4, 5, 6};
        int[] z = VectorAddition(x, y);

        for (int i = 0; i < z.length; i++)
            System.out.print(z[i] + " ");
    }
}