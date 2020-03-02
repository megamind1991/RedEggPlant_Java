package com.rep.Inheritance;

import lombok.Getter;
import lombok.Setter;

public class FieldInheritance {
    public static void main(String[] args) {
        FieldSubVO FieldSubVO = new FieldSubVO();
        FieldSubVO.print();
    }
}

@Getter
@Setter
class FieldSuperVo {
    protected int num = 100;

    protected String name = "liujie";

}

@Getter
@Setter
class FieldSubVO extends FieldSuperVo {

    protected int num = 200;

    protected String name = "juanjuan";

    public void print() {
        System.out.println(num);
        System.out.println(name);
        System.out.println(super.num);
        System.out.println(super.name);
    }

}
