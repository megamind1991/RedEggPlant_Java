package com.rep.interfaces;

interface Walkable {
    void walk();/* from w w w. j a va 2 s . c o m */
}

class Person implements Walkable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println(name + " (a person) is walking.");
    }
}

class Duck implements Walkable {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println(name + " (a duck) is walking.");
    }
}

class Walkables {
    public static void letThemWalk(Walkable[] list) {
        for (Walkable w : list) {
            w.walk();
        }
    }
}

public class InterfaceArrayMain {
    public static void main(String[] args) {
        Walkable[] w = new Walkable[3];
        w[0] = new Person("a");
        w[1] = new Duck("b");
        w[2] = new Person("d");

        Walkables.letThemWalk(w);

        // ServiceLoader<Walkable> walkables = ServiceLoader.load(Walkable.class);
        // for (Walkable walkable : walkables) {
        // }
    }
}