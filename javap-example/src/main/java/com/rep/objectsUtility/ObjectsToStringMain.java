package com.rep.objectsUtility;

import java.util.Objects;

/**
 * Convert value to String with Objects.toString
 */
public class ObjectsToStringMain {
    public static void main(String[] args) {
        // toString() method test
        System.out.println("toString(null) is " + Objects.toString(null));
        // 如果第一个参数是null 则返回第二个参数
        System.out.println("toString(null, \"XXX\") is " + Objects.toString(null, "XXX"));
    }// from w w w . j a va 2s . co m

}