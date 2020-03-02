package com.rep.Inheritance;

import lombok.Getter;
import lombok.Setter;

/**
 * 演示早期绑定 和 晚绑定
 *
 * 静态非静态是有区别的 非静态的跟着对象地址走，静态的跟着类走
 *
 * https://blog.csdn.net/xq_nbu/article/details/88537753
 */
public class EarlyBinding {
    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        ChilderClass childerClass = new ChilderClass();

        System.out.println(parentClass.instanceVariable);
        System.out.println(parentClass.getInstanceVariable());
        System.out.println(parentClass.statiCount);
        System.out.println(parentClass.statiCount2);
        parentClass.print();
        parentClass.print2();

        System.out.println("---------------------------------");

        System.out.println(childerClass.instanceVariable);
        System.out.println(childerClass.getInstanceVariable());
        System.out.println(childerClass.statiCount);
        System.out.println(childerClass.statiCount2);
        childerClass.print();
        childerClass.print2();

        System.out.println("---------------------------------类型转化的过程");

        System.out.println(((ParentClass) childerClass).instanceVariable);
        System.out.println(((ParentClass) childerClass).getInstanceVariable());
        System.out.println(((ParentClass) childerClass).statiCount);
        System.out.println(((ParentClass) childerClass).statiCount2);
        ((ParentClass) childerClass).print();
        ((ParentClass) childerClass).print2();


        System.out.println("-----------------------------------子父类赋值的过程");

        parentClass = childerClass;
        System.out.println(parentClass.instanceVariable);
        System.out.println(parentClass.getInstanceVariable());
        System.out.println(parentClass.statiCount);
        System.out.println(parentClass.statiCount2);
        parentClass.print();
        parentClass.print2();
    }
}

@Getter
@Setter
class ParentClass {
    /** instance variable */
//    private String instanceVariable = "superVarible";
    public String instanceVariable = "superVarible";

    public static final int statiCount = 100;

    public static int statiCount2 = 300;

    public static void print() {
        System.out.println("parent print");
    }

    public void print2() {
        System.out.println("parent print2");
    }

}

@Getter
@Setter
class ChilderClass extends ParentClass {

    /** instance variable */
//    private String instanceVariable = "childerVar2";
    public String instanceVariable = "childerVar2";

    public static final int statiCount = 200;

    public static int statiCount2 = 400;

    public static void print() {
        System.out.println("childer print");
    }

    public void print2() {
        System.out.println("childer print2");
    }
}
