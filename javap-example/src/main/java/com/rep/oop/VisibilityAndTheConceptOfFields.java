package com.rep.oop;

class TestClass {
    private long visibleOnlyInThisClass;

    double visibleFromEntirePackage;

    /* w w w .j av a 2 s . com */
    void setLong(long val) {
        visibleOnlyInThisClass = val;
    }

    long getLong() {
        return visibleOnlyInThisClass;
    }
}

public class VisibilityAndTheConceptOfFields {
    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.setLong(32768);
        tc.visibleFromEntirePackage = 3.1415926535;
        System.out.println(tc.getLong());
        System.out.println(tc.visibleFromEntirePackage);
    }
}