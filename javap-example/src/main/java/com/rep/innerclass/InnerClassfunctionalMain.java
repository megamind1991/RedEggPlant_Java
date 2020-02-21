package com.rep.innerclass;

import java.util.function.Consumer;

/**
 * Create instance of inner class for functional interface
 */
public class InnerClassfunctionalMain {
    public static void main(String[] args) {
        VariableAccessInner vai = new VariableAccessInner();
        VariableAccessInner.InnerClass inner = vai.new InnerClass();
        inner.lambdaInMethod("Hello");
    }// from www . j av a 2 s . c o m
}

class VariableAccessInner {
    String CLASSA = "Class-level A";

    class InnerClass {
        String CLASSA = "Class-level B";

        void lambdaInMethod(String passedIn) {
            String METHODA = "Method-level A";
            // passedIn = "test";
            Consumer<String> l1 = x -> {
                System.out.println(x);
                System.out.println("CLASSA Value: " + CLASSA);
                System.out.println("METHODA Value: " + METHODA);
            };
            l1.accept(CLASSA);
            l1.accept(passedIn);
        }
    }
}