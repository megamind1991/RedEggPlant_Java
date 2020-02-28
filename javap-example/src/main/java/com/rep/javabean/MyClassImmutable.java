package com.rep.javabean;

public class MyClassImmutable {
    int prop;

    // The constructor that initializes the immutable property prop
    public MyClassImmutable(int prop) {
        this.prop = prop;
    }

    // The immutable property
    public int getProp() {
        return prop;
    }
}