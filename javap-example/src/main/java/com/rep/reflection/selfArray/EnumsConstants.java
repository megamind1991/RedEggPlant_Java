package com.rep.reflection.selfArray;

import java.awt.*;
import java.util.Arrays;

/**
 * 枚举类的反射取值
 */
public class EnumsConstants {
    public static void main(String[] args) {
        Class<?> aClass = Eon.class;
        System.out.println(aClass.getName());
        System.out.println(Arrays.asList(aClass.getEnumConstants()));
        System.out.println(Arrays.asList(Eon.values()));
    }
}

enum Eon {/*from  ww w.j  av  a2  s . co  m*/
    HADEAN, ARCHAEAN, PROTEROZOIC, PHANEROZOIC
}