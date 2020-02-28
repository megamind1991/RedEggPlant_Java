package com.rep.Inheritance;

import lombok.Getter;
import lombok.Setter;

/**
 * 演示早期绑定失败
 */
public class EarlyBinding {
    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        ChilderClass childerClass = new ChilderClass();

        System.out.println(parentClass.getInstanceVariable());
        System.out.println(parentClass.statiCount);
        parentClass.print();

        System.out.println("---------------------------------");

        System.out.println(childerClass.getInstanceVariable());
        System.out.println(childerClass.statiCount);
        childerClass.print();

        System.out.println("--------------------------------");

        System.out.println(((ParentClass) childerClass).getInstanceVariable());
        System.out.println(((ParentClass) childerClass).statiCount);
        ((ParentClass) childerClass).print();

        System.out.println("------------------------------------");

        parentClass = childerClass;
        System.out.println(parentClass.getInstanceVariable());
        System.out.println(parentClass.statiCount);
        parentClass.print();
    }
}

@Getter
@Setter
class ParentClass {
    /** instance variable */
    private String instanceVariable = "superVarible";

    public static final int statiCount = 100;

    public static void print() {
        System.out.println("parent print");
    }

}

@Getter
@Setter
class ChilderClass extends ParentClass {

    /** instance variable */
    private String instanceVariable = "childerVar2";

    public static final int statiCount = 200;

    public static void print() {
        System.out.println("childer print");
    }
}
