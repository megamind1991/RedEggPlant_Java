package com.rep.innerclass;

public class ExtendClass2 extends Class1 {
    public ExtendClass2() {
        ic = new InnerClass2();
    }// from w w w. jav a2s. c o m

    static public void main(String[] args) {
        ExtendClass2 c2 = new ExtendClass2();
        c2.displayStrings();
    }

    protected class InnerClass2 extends InnerClass1 {
        public String getAnotherString() {
            return "InnerClass2 version of getAnotherString invoked";
        }
    }

}

class ExtendClass1 {
    protected InnerClass1 ic;

    public ExtendClass1() {
        ic = new InnerClass1();
    }

    public void displayStrings() {
        System.out.println(ic.getString() + ".");
        System.out.println(ic.getAnotherString() + ".");
    }

    static public void main(String[] args) {
        Class1 c1 = new Class1();
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