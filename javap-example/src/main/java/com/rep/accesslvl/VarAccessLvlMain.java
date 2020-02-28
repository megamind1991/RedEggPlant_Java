package com.rep.accesslvl;

public class VarAccessLvlMain {
    private int num1; // private access level

    int num2; // package-level access

    protected int num3; // protected access level

    public int num4; // public access level

    public static int count = 1; // public access level

    // m1() method has private access level
    private void m1() {
    } // w w w . j ava 2 s .co m

    // m2() method has package-level access
    void m2() {
    }

    // m3() method has protected access level
    protected void m3() {
    }

    // m4() method has public access level
    public void m4() {
    }

    // private access level
    private static void doSometing() {
    }
}