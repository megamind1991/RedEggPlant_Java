package com.rep.Inheritance;

import lombok.Getter;
import lombok.Setter;

/**
 *  没有内部类
 */
public class SupperMethodClass {
    public static void main(String[] args) {
        SubVO subVO = new SubVO();
        subVO.print();
        subVO.callSuperPrint();
    }
}

@Getter
@Setter
class SuperVO {
    public void print() {
        System.out.println("super print");
    }
}

@Getter
@Setter
class SubVO extends SuperVO {
    public void print() {
        super.print();
        System.out.println("subvo print");
    }

    public void callSuperPrint() {
        super.print();
    }
}