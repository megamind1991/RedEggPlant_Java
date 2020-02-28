package com.rep.interfaces;

interface Walkabled {
    void walk();/* w w w .j ava 2 s .co m */
}

interface Swimmabled {
    void swim();
}

class Turtle implements Walkabled, Swimmabled {
    private String name;

    public Turtle(String name) {
        this.name = name;
    }

    // Adding a bite() method to the Turtle class
    public void bite() {
        System.out.println(name + " (a turtle) is biting.");
    }

    // Implementation for the walk() method of the Walkable interface
    public void walk() {
        System.out.println(name + " (a turtle) is walking.");
    }

    // Implementation for the swim() method of the Swimmable interface
    public void swim() {
        System.out.println(name + " (a turtle) is swimming.");
    }
}

public class ImplementMultiInterfaceMain {
    // 一个对象实现多个接口
    public static void main(String[] args) {
        Turtle turti = new Turtle("aa");
        ImplementMultiInterfaceMain.letItBite(turti);
        letItWalk(turti);
        letItSwim(turti);
    }

    public static void letItBite(Turtle t) {
        t.bite();
    }

    public static void letItWalk(Walkabled w) {
        w.walk();
    }

    public static void letItSwim(Swimmabled s) {
        s.swim();
        ;
    }
}