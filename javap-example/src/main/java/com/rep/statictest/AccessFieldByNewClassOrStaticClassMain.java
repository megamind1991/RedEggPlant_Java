package com.rep.statictest;

public class AccessFieldByNewClassOrStaticClassMain {
    public static void main(String[] args) {
        MyClass mt = new MyClass();
        System.out.println("Invoking instance method...");
        mt.printMN();// from w w w. j a v a 2 s . c om
        System.out.println("Invoking class method on class name...");

        MyClass.printM();

        System.out.println("Invoking class method on an instance...");

        // Invoke the class method using the instance reference
        mt.printM();
    }
}

class MyClass {
    static int m = 100; // A static variable

    int n = 200; // An instance variable

    static void printM() {
        System.out.println("printM() - m = " + m);
    }

    void printMN() {
        /* We can refer to both static and instance variables m and n in this method */
        System.out.println("printMN() - m = " + m);
        System.out.println("printMN() - n = " + n);
    }
}