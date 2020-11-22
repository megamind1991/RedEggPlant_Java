package com.rep.reflection.selfArray;

import java.lang.reflect.Field;

public class GetArrayTypeField {


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("java.util.ArrayList");
        for (Field declaredField : aClass.getDeclaredFields()) {
             // 获取属性的类型
            Class<?> type = declaredField.getType();
            // 类型是否是数组
            if (type.isArray()) {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>");
                System.out.println(declaredField);
                System.out.println(declaredField.getName());
                System.out.println(type);
                System.out.println(type.getComponentType());
            }
        }
    }
}
