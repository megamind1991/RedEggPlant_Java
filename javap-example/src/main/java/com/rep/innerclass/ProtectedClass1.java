package com.rep.innerclass;

import java.util.*;

public class ProtectedClass1 {
    protected InnerClass1 ic;

    public ProtectedClass1() {
        ic = new InnerClass1();
    }/* from w w w.j av a 2 s . co m */

    public void displayStrings() {
        System.out.format("%s.%n", ic.getString());
        System.out.format("%s.%n", ic.getAnotherString());
    }

    static public void main(String[] args) {
        ProtectedClass1 c1 = new ProtectedClass1();
        c1.displayStrings();
    }

    protected class InnerClass1 {
        public String getString() {
            return "InnerClass1: getString invoked";
        }

        public String getAnotherString() {
            return "InnerClass1: getAnotherString invoked";
        }
    }
}