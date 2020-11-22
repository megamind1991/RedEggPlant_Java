package com.rep.reflection.selfAnnotation;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.rep.recursive.RecursiveFactorialClass;

/**
 * 打印对于方法上的访问级别
 */
public class MethodModifierSpy {
    private static int count;

    private static synchronized void inserence(){
        count++;
    }

    public static synchronized int getCount() {
        return count;
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        RecursiveFactorialClass recursiveFactorialClass = new RecursiveFactorialClass();
 // 方法的访问级别
        Class<?> c = Class.forName("com.rep.recursive.RecursiveFactorialClass");
        for (Method declaredMethod : c.getDeclaredMethods()) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(declaredMethod.getName());
            System.out.println(declaredMethod.toGenericString());
//            PUBLIC: 1
//            PRIVATE: 2
//            PROTECTED: 4
//            STATIC: 8
//            FINAL: 16
//            SYNCHRONIZED: 32
//            VOLATILE: 64
//            TRANSIENT: 128
//            NATIVE: 256
//            INTERFACE: 512
//            ABSTRACT: 1024
//            STRICT: 2048
            System.out.println(Modifier.toString(declaredMethod.getModifiers()));
            System.out.println(declaredMethod.isSynthetic());
            System.out.println(declaredMethod.isVarArgs());
            System.out.println(declaredMethod.isBridge());
        }

    }
}
