package com.rep.reflection.selfAnnotation;

import java.lang.annotation.Annotation;

import javax.annotation.Resource;

import static java.lang.System.out;

/**
 * 打印某个类上的注解信息
 */
@Resource
public class PrintAnnotationByReflection {
    public static void printAnnotations(Class<?> c) {
        Annotation[] annotations = c.getAnnotations();
        out.format("Annotation => %n");

        if (annotations.length == 0) {
            out.format("  --%s", "No declared annotation found");
        } else {// w  ww.j  ava 2  s  . co  m
            for (Annotation a : annotations) {
                out.println(a);
                out.println(a.getClass().getName());
                out.println(a.getClass().getSimpleName());
                out.format("--%s", a.getClass().getCanonicalName());
            }
        }
        out.format("%n%n");
    }

    public static void main(String[] args) {
        printAnnotations(PrintAnnotationByReflection.class);
    }
}
