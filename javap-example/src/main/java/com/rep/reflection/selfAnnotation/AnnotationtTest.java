package com.rep.reflection.selfAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import lombok.Synchronized;

/**
 *
 * 接口动态代理
 *
 */
public class AnnotationtTest {
    public static void main(String[] argv) throws Exception {
        Class annotationClass = String.class;
        Annotation annotation = instantiateAnnotation(annotationClass);
        System.out.println(annotation);
        System.out.println(annotation.hashCode());
        System.out.println(annotation.annotationType());
    }//  ww  w .j ava 2 s.  co  m

    public static Annotation instantiateAnnotation(
            final Class<? extends Annotation> annotationClass) {
        // source http://stackoverflow.com/questions/2786292/is-it-possible-to-instantiate-a-java-annotation-given-a-class-extends-annotatio
        return (Annotation) Proxy.newProxyInstance(
                annotationClass.getClassLoader(),
                new Class[] { Annotation.class }, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) {
                        if (method.getName().equals("hashCode")) {
                            return annotationClass.getName().hashCode();
                        } else if (method.getName().equals("toString")) {
                            return "[AnnotationObj:"
                                    + annotationClass.getName() + "]";
                        } else if (method.getName().equals("equals")) {
                            if (args[0] == null) {
                                return false;
                            }

                            Annotation annotation = (Annotation) args[0];

                            return annotationClass.getName().equals(
                                    annotation.annotationType().getName());
                        }

                        return annotationClass;
                    }
                });
    }
}
