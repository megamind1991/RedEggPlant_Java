package com.rep.statictest;

class Person implements Walkable {
    private String name;

    public Person(String name) {
        this.name = name;
    }/* w ww.j ava 2s. c o m */

    public void walk() {
        System.out.println(name + " (a person) is walking.");
    }
}

class Duck implements Walkable {
    private String name;

    /**
     * @Description : 功能说明
     * @Author : 大刘
     * @Param null
     * @Return :
     */
    public Duck(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println(name + " (a duck) is walking.");
    }
}

interface Walkable {
    // An abstract method
    void walk();

    // A static convenience method
    /**
     * @Description : 功能说明
     * @Author : 大刘
     * @Param null
     * @Return : 这是个接口内的方便方法 体现该接口能做出的功能
     */
    static void letThemWalk(Walkable[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i].walk();
        }
    }
}

public class StaticConvenienceMethodMain {
    public static void main(String[] args) {
        Walkable[] w = new Walkable[3];
        w[0] = new Person("a");
        w[1] = new Duck("b");
        w[2] = new Person("c");

        Walkable.letThemWalk(w);
    }
}