package com.rep.javabean;

import java.beans.Expression;

/**
 * JavaBean enhancements in Java 7 javabean增强
 */
public class PersonEnhancementsMain {

    public static void main(String args[]) {
        PersonExp person = new PersonExp();
        String arguments[] = {
            "Peter"
        };
        Expression expression = new Expression(null, person, "setName", arguments);

        try {
            System.out.println("Name: " + person.getName());
            expression.execute();
            System.out.println("Name: " + person.getName());

            System.out.println();
            expression = new Expression(null, person, "getName", null);
            System.out.println("Name: " + person.getName());
            expression.execute();
            System.out.println("getValue: " + expression.getValue());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}