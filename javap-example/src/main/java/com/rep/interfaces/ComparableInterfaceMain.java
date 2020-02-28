package com.rep.interfaces;

import java.util.Arrays;

/**
 * 实现comparable接口 必须处理比较方法(泛型接口)
 */
public class ComparableInterfaceMain {
    public static void main(String[] args) {
        ComparablePerson[] persons = new ComparablePerson[] {
            new ComparablePerson("A", "AA"), new ComparablePerson("B", "BB"), new ComparablePerson("C", "CC")
        };
        /* w w w .ja v a 2 s . com */
        System.out.println("Before sorting...");
        print(persons);

        // Sort the persons list
        Arrays.sort(persons);

        System.out.println("\nAfter sorting...");
        print(persons);
    }

    public static void print(ComparablePerson[] persons) {
        for (ComparablePerson person : persons) {
            System.out.println(person);
        }
    }
}

class ComparablePerson implements Comparable<ComparablePerson> {

    private String firstName;

    private String lastName;

    public ComparablePerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Compares two persons based on their last names. If last names are
    // the same, use first names
    public int compareTo(ComparablePerson anotherPerson) {
        int diff = getLastName().compareTo(anotherPerson.getLastName());
        if (diff == 0) {
            diff = getFirstName().compareTo(anotherPerson.getFirstName());
        }
        return diff;
    }

    public String toString() {
        return getLastName() + ", " + getFirstName();
    }
}