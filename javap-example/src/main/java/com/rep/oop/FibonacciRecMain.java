package com.rep.oop;

import java.util.Arrays;
import java.util.function.Function;

public class FibonacciRecMain {
    public static int Factorial(int n) {
        if (n == 0)/* www. ja va 2 s. c o m */
            return 1; // Terminal stage
        else
            return n * Factorial(n - 1); // Apply recurrence equation
    }

    // 函数式编程(FP)
    public static Function<Integer, Integer> factorial = x -> x == 0 ? 1 : x * FibonacciRecMain.factorial.apply(x - 1);

    public static Function<Integer, Function<Integer, Integer>> factorialTail = x -> acc -> x == 0 ? acc
        : FibonacciRecMain.factorialTail.apply(x - 1).apply(acc * x);

    public static int Fibonacci(int n) {
        if (n <= 1)
            return 1;// www .j a v a2 s . co m
        else
            return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    static int FibonacciRecTerm(int n, int i, int a, int b) {
        if (n == i)// from w ww. jav a 2s . co m
            return a;
        else
            return FibonacciRecTerm(n, i + 1, a + b, a);
    }

    static int FibonacciLaunch(int n) {
        if (n <= 1)
            return n;
        else
            return FibonacciRecTerm(n, 0, 0, 1);
    }

    static double LogarithmicMean(double[] array, int i, int j) {
        if (j - i == 0)
            return array[i];
        else {// ww w.ja v a2s .c o m
            int n = j - i + 1;
            return (n - 1) * (LogarithmicMean(array, i + 1, j) - LogarithmicMean(array, i, j - 1))
                / (Math.log(array[j]) - Math.log(array[i]));
        }
    }

    static double LogarithmicMean(double[] array) {
        return LogarithmicMean(array, 0, array.length - 1);
    }

    static long FactorialRecTerminal(int n, int i, int result) {
        if (n == i)/* www.jav a2s. com */
            return result;
        else
            return FactorialRecTerminal(n, i + 1, result * (i + 1));
    }

    static long FactorialLaunch(int n) {
        if (n <= 1)
            return n;
        else
            return FactorialRecTerminal(n, 1, 1);
    }

    public static void main(String[] arg) {
        System.out.println("10!=" + Factorial(10));

        int i;
        for (i = 0; i <= 30; i++)
            System.out.print(Fibonacci(i) + " ");

        double[] d = new double[] {
            1.2, 3, 4, 5, 6, 7, 8, 9
        };
        System.out.println();
        double r = LogarithmicMean(d);
        System.out.println(r);

        System.out.println("Factorial 10!=" + FactorialLaunch(10));

        System.out.println("Lamel Factorial 10!=" + FibonacciRecMain.factorial.apply(10));

        System.out.println("Fibonacci(7)=" + FibonacciLaunch(7));
    }

}