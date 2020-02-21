package com.rep.oop;

class MySuperClass extends MyBase {
    public MySuperClass() {
        super(); // Injected by the compiler
        System.out.println("Inside CSub() constructor.");
    }/* w ww . j a v a2 s.c om */
}

class MyBase {
    public MyBase() {
        // 编译器会自动在子类构造函数的第一句加上 super();
        // 来调用父类的无参构造器；此时可以省略不写。
        // 如果想写上的话必须在子类构造函数的第一句，可以通过super来调用父类其他重载的构造方法，只要相应的把参数传过去就好。
        super(); // Injected by the compiler
        System.out.println("Inside CSuper() constructor.");
    }
}

public class SuperConstructorsMain {
    public static void main(String[] args) {
        // 先调用基类构造器 然后再自己的构造器
        MySuperClass cs = new MySuperClass();
        // 因此，super的作用主要在下面三种情况下：
        //
        // 1、调用父类被子类重写的方法；
        //
        // 2、调用父类被子类重定义的字段（被隐藏的成员变量）；
        //
        // 3、调用父类的构造方法；
        //
        // 其他情况，由于子类自动继承了父类相应属性方法，关键字super可以不显示写出来
    }
}
