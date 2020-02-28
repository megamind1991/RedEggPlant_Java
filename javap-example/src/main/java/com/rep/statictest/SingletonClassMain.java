package com.rep.statictest;

class SingletonClass {
    // 使用静态使他只此一个
    private static SingletonClass instance;

    private SingletonClass() {
    }/* from ww w . j a v a 2 s. c o m */

    // 获取的时候判断时候已经有了
    public static SingletonClass getInstance() {
        if (instance == null)
            instance = new SingletonClass();
        return instance;
    }
}

public class SingletonClassMain {
    public static void main(String[] args) {
        SingletonClass s1 = SingletonClass.getInstance();
        SingletonClass s2 = SingletonClass.getInstance();
        if (s1 == s2)
            System.out.println("The objects are the same");
        else
            System.out.println("The objects are not the same");

    }

}