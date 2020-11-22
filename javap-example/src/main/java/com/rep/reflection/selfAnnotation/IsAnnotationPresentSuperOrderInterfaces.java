package com.rep.reflection.selfAnnotation;

import java.lang.annotation.Annotation;

/**
 *
 * 判断A类是否是B类的注解类 包括其父类以及接口
 *
 */
public class IsAnnotationPresentSuperOrderInterfaces {
    public static void main(String[] argv) throws Exception {
        Class clazz = String.class;
        Class a = String.class;
        System.out.println(isAnnotationPresent(clazz, a));
    }//from w w  w.j ava 2s . com

    public static boolean isAnnotationPresent(Class<?> clazz,
                                              Class<? extends Annotation> a) {

        if (clazz == null) {
            return false;
        }

        if (clazz.isAnnotationPresent(a)) {
            return true;
        }

        if (isAnnotationPresentOnSuperClasses(clazz, a)) {
            return true;
        }

        if (isAnnotationPresentOnInterfaces(clazz, a)) {
            return true;
        }

        return false;
    }

    private static boolean isAnnotationPresentOnSuperClasses(
            Class<?> clazz, Class<? extends Annotation> a) {

        if (clazz == null) {
            return false;
        }

        Class<?> c = clazz.getSuperclass();
        while (c != null && !c.equals(Object.class)) {
            if (c.isAnnotationPresent(a)) {
                return true;
            }
            if (isAnnotationPresentOnInterfaces(c, a)) {
                return true;
            }
            c = c.getSuperclass();
        }

        if (isAnnotationPresentOnInterfaces(clazz.getSuperclass(), a)) {
            return true;
        }

        return false;
    }

    private static boolean isAnnotationPresentOnInterfaces(Class<?> clazz,
                                                           Class<? extends Annotation> a) {

        if (clazz == null) {
            return false;
        }

        for (Class<?> i : clazz.getInterfaces()) {
            if (i.isAnnotationPresent(a)) {
                return true;
            }
            if (isAnnotationPresentOnInterfaces(i, a)) {
                return true;
            }
        }

        return false;
    }
}
