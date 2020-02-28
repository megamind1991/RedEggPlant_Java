package com.rep.Inheritance;

import lombok.Getter;
import lombok.Setter;

/**
 * 继承了父级的属性
 */
public class CreateInheritanceClass {

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setName("juanjuan");

        System.out.println("final name 》》》 " + manager.getName());
    }

}

@Getter
@Setter
class Employee {
    /** name */
    private String name = "Unknow";
}

@Getter
@Setter
class Manager extends Employee {

}
