package com.rep.oop;

import java.lang.reflect.Constructor;

public class ReflectConstructorMain {

    public static void main(String[] argv) {
        // By obtaining a list of all Constructors object.
        Class cls = String.class;
        Constructor[] cons = cls.getDeclaredConstructors();
        for (int i = 0; i < cons.length; i++) {
            Class[] paramTypes = cons[i].getParameterTypes();
            // process(cons[i]);
        } /* from w w w. ja v a 2 s. c o m */

        try {
            Constructor con = java.awt.Point.class.getConstructor(new Class[] {
                int.class, int.class
            });
            // process(con);
        }
        catch (NoSuchMethodException e) {
        }
    }
}