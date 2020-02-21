package com.rep.oop;

public class CloneMain {
    public static void main(String[] args) {
        MyClass dh = new MyClass(100.00);
        // Clone dh//from w ww .j a v a 2 s . c o m
        MyClass dhClone = (MyClass) dh.clone();

        // Print the values in original and clone
        System.out.println("Original:" + dh.getValue());
        System.out.println("Clone :" + dhClone.getValue());

        // Change the value in original and clone
        dh.setValue(2.00);
        dhClone.setValue(4.00);

        // Print the values in original and clone again
        System.out.println("Original:" + dh.getValue());
        System.out.println("Clone :" + dhClone.getValue());
    }
}

class MyClass implements Cloneable {
    private double value;

    public MyClass(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public Object clone() {
        MyClass copy = null;
        try {
            // Call the clone() method of the Object class
            copy = (MyClass) super.clone();
        }
        catch (CloneNotSupportedException e) {
            // If anything goes wrong during cloning, print the error details
            e.printStackTrace();
        }
        return copy;
    }
}