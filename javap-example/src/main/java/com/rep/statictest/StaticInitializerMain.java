package com.rep.statictest;

/**
 * 静态代码块（载入类的时候执行），普通代码块（每次实例化的时候执行）
 */
public class StaticInitializerMain {
    private static int num;

    // A static initializer. Note the use of the keyword static below.
    static {/* from www .ja v a 2 s . co m */
        num = 1;
        System.out.println("Inside static initializer.");
    }

    // An instance initializer
    {
        System.out.println("Inside instance initializer.");
    }

    // Constructor
    public StaticInitializerMain() {
        System.out.println("Inside constructor.");
    }

    /**
     * @Description : 功能说明
     * @Author : 大刘
     * @Param null
     * @Return : XX
     */
    public static void main(String[] args) {
        System.out.println("Inside main() #1. num: " + num);

        // Declare a reference variable of the class
        StaticInitializerMain si;

        System.out.println("Inside main() #2. num: " + num);

        // Create an object
        new StaticInitializerMain();

        System.out.println("Inside main() #3. num: " + num);

        // Create another object
        new StaticInitializerMain();
    }
}