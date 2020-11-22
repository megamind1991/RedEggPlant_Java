package com.rep.reflection.selfArray;


import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 使用反射来创建数组
 */
public class ArrayCreator {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 类名
        String cName = "java.math.BigInteger";
        // String值列表
        String[] cValus = {"112", "113", "114"};
        // 集合长度
        int length = cValus.length;

        // 根据类名生成类对象
        Class<?> aClass = Class.forName(cName);
        // 将此类变成数组类
        Object cArray = Array.newInstance(aClass, length);

        for (int i = 0; i < cValus.length; i++) {
            String cValus1 = cValus[i];

            // 使用构造函数使用String类型生成对应数据
            Constructor<?> constructor = aClass.getConstructor(String.class);
            Object o = constructor.newInstance(cValus1);

            // 对数组赋值
            Array.set(cArray, i, o);
        }

        // 打印内容
        System.out.println(Arrays.toString((Object[]) cArray));
        System.out.println(Arrays.toString((BigInteger[]) cArray));


        // 对象是否是数组
        System.out.println(cValus.getClass().isArray());


        Object o1 = new int[1][2][3];
        System.out.println(Array.getLength(o1));
        int num = 0;
        Class<?> aClass1 = o1.getClass();

        while (aClass1.isArray()) {
            System.out.println(num++);
            // 获取数组内类型
            aClass1 = aClass1.getComponentType();
        }

    }
}
