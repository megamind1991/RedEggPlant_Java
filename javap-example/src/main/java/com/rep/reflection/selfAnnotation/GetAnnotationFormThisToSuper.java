package com.rep.reflection.selfAnnotation;

import java.lang.annotation.Annotation;

/**
 *
 * 返回指定类型的注解 没有的话测返回null，包括父类都在里面
 *
 */
public class GetAnnotationFormThisToSuper {
    public static void main(String[] argv) throws Exception {
        Class clazz = String.class;
        Class annotationClass = String.class;
        System.out.println(getAnnotationInLineage(clazz, annotationClass));
    }/*  w w w .  j a v  a 2  s.  c om*/

    /**
     * Returns an annotation for the specified type if such an annotation is present, else null. The superclasses of the
     * class are included in the search if the annotation is not found in the leaf class.
     * <p/>
     * This method find the same kinds of annotations that are found by {@link Class#getAnnotation(Class)} with the
     * exception that it includes superclasses in the search as well.
     *
     * @param <A>             the annotation
     * @param clazz           the class
     * @param annotationClass the class of the annotation you are looking for.
     * @return the annotation if present, otherwise null
     * @see Class#getAnnotation(Class) for more details
     */
    public static <A extends Annotation> A getAnnotationInLineage(
            Class<?> clazz, Class<A> annotationClass) {

        A annotation = clazz.getAnnotation(annotationClass);
        if (annotation != null) {
            return annotation;
        }

        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null && !superClass.equals(Object.class)) {
            return getAnnotationInLineage(superClass, annotationClass);
        } else {
            return null;
        }
    }
}
