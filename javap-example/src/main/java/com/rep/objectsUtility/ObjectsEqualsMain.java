package com.rep.objectsUtility;

import java.util.Objects;

/**
 * 对象公共方法 Objects.equals
 */
public class ObjectsEqualsMain {
    public static void main(String[] args) {
        // Test for equality
        boolean isEqual = Objects.equals(null, null);
        System.out.println("null is equal to null: " + isEqual);

        isEqual = Objects.equals(null, "XYZ");
        System.out.println("null is equal to XYZ: " + isEqual);

    }/* from w w w. ja v a 2 s . c om */

}