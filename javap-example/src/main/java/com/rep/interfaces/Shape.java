package com.rep.interfaces;

// 内部类+接口 无公开的类的话 以接口对外公开
interface Shape {
    void draw();// from www .ja v a 2 s . c o m
}

/**
 * Demonstrates the Use of an Interface Type as a Variable Type 演示接口类型 作为参数
 */
class Main {
    // Interface type to define instance variable
    private Shape myShape;

    // Interface type to define parameter type for a constructor
    public Main(Shape a) {
        this.myShape = a;
    }

    // Interface type to define return type of a method
    public Shape getSwimmable() {
        return this.myShape;
    }

    // Interface type to define parameter type for a method
    public void setSwimmable(Shape a) {
        this.myShape = a;
    }

    public void letItSwim() {
        // Interface type to declare a local variable
        Shape a = null;

        a = this.myShape;

        a.draw();
    }
}