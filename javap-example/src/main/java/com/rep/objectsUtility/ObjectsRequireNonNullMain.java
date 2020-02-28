package com.rep.objectsUtility;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Testing requireNonNull(T obj, String message) from Objects class
 */
public class ObjectsRequireNonNullMain {
    public static void main(String[] args) {
        // Testing requireNonNull(T obj, String message)
        try {/* w ww. j a v a 2 s .c o m */
            printName("test");
            printName(null);
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        // requireNonNull(T obj, Supplier<String> messageSupplier)
        try {
            Supplier<String> messageSupplier = () -> "Name is required. ";
            printNameWithSuplier("aaa", messageSupplier);
            printNameWithSuplier(null, messageSupplier);
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printName(String name) {
        // Test name for not null. Generate a NullPointerException if it is null.
        Objects.requireNonNull(name, "Name is required.");
        System.out.println("--------------------------");
        // Print the name if the above statement dod not throw an exception
        System.out.println("Name is " + name);
    }

    public static void printNameWithSuplier(String name, Supplier<String> messageSupplier) {
        // Test name for not null. Generate a NullPointerException if it is null.
        Objects.requireNonNull(name, messageSupplier);
        System.out.println("--------------------------");
        System.out.println("Name is " + name);
    }

}