package com.rep.oop;

public class ShallowCloneMain {
    public static void main(String[] args) {
        ShallowClone sc = new ShallowClone(100.00);
        ShallowClone scClone = (ShallowClone) sc.clone();

        // Print the value in original and clone
        System.out.println("Original:" + sc.getValue());
        System.out.println("Clone :" + scClone.getValue());

        // Change the value in original and it will change the value
        // for clone too because we have done shallow cloning
        sc.setValue(200.00);// w  w  w.j a va2  s  .  c o  m

        // Print the value in original and clone
        System.out.println("Original:" + sc.getValue());
        System.out.println("Clone :" + scClone.getValue());
    }
}

class MyBaseClass implements Cloneable {
    private double value;

    public MyBaseClass(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public Object clone() {
        MyBaseClass copy = null;
        try {
            // Call the clone() method of the Object class
            copy = (MyBaseClass) super.clone();
        } catch (CloneNotSupportedException e) {
            // If anything goes wrong during cloning, print the error details
            e.printStackTrace();
        }
        return copy;
    }
}

class ShallowClone implements Cloneable {
    private MyBaseClass holder = new MyBaseClass(0.0);

    public ShallowClone(double value) {
        this.holder.setValue(value);
    }

    public void setValue(double value) {
        this.holder.setValue(value);
    }

    public double getValue() {
        return this.holder.getValue();
    }

    public Object clone() {
        ShallowClone copy = null;
        try {
            copy = (ShallowClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }
}