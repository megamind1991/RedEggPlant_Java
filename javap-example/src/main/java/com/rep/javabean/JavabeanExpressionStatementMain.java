package com.rep.javabean;

import java.beans.Expression;
import java.beans.Statement;

public class JavabeanExpressionStatementMain {
    public static void main(String[] args) throws Exception {
        Object o = new MyBean1();
        try {// from w ww. j av a2 s . co m
             // Get the value of prop1
            Expression expr = new Expression(o, "getProp1", new Object[0]);
            expr.execute(); // 执行之后值被设置进入Expression的value中
            String s = (String) expr.getValue();

            // Set the value of prop1
            Statement stmt = new Statement(o, "setProp1", new Object[] {
                "new string"
            });
            stmt.execute();

            // Get the value of prop2
            expr = new Expression(o, "getProp2", new Object[0]);
            expr.execute();
            int i = ((Integer) expr.getValue()).intValue();

            // Set the value of prop2
            stmt = new Statement(o, "setProp2", new Object[] {
                new Integer(123)
            });
            stmt.execute();

            // Get the value of prop1
            expr = new Expression(o, "getProp3", new Object[0]);
            expr.execute();
            byte[] bytes = (byte[]) expr.getValue();

            // Set the value of prop1
            stmt = new Statement(o, "setProp3", new Object[] {
                new byte[] {
                    0x12, 0x23
                }
            });
            stmt.execute();
        }
        catch (Exception e) {
        }
    }
}

class MyBean1 {
    // Property prop1
    String prop1;

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String s) {
        prop1 = s;
    }

    // Property prop2
    int prop2;

    public int getProp2() {
        return prop2;
    }

    public void setProp2(int i) {
        prop2 = i;
    }

    // Property prop3
    byte[] prop3;

    public byte[] getProp3() {
        return prop3;
    }

    public void setProp3(byte[] bytes) {
        prop3 = bytes;
    }
}