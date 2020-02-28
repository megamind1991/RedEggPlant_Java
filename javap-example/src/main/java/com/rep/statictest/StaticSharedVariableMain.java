package com.rep.statictest;

class StaticDemo {
    public static boolean oneValueForAllObjects = false;
}

/**
 * @Description : 功能说明
 * @Author : 大刘
 * @Param null
 * @Return : 多个实例共享静态变量
 */
public class StaticSharedVariableMain {
    public static void main(String[] args) {
        StaticDemo sd1 = new StaticDemo();
        StaticDemo sd2 = new StaticDemo();
        System.out.println(sd1.oneValueForAllObjects);
        System.out.println(sd2.oneValueForAllObjects);
        sd1.oneValueForAllObjects = true;
        System.out.println(sd1.oneValueForAllObjects);
        System.out.println(sd2.oneValueForAllObjects);
    }/* from w w w . jav a2 s.c o m */

}