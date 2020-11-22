package com.rep.reflection.selfClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ClassDeclarationSpy {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<HashMap> hashMapClass = HashMap.class;
//        正常情况下：getSimpleName获取的就是最直接的类名，getCanonicalName和getName获取到的都是包含路径的类名。
//        内部类有点特殊，getName获取是路径.类名$内部类。
        System.out.println("Class普遍名称: " + hashMapClass.getCanonicalName());
        System.out.println("类的访问等级：" + Modifier.toString(hashMapClass.getModifiers()));
        TypeVariable<Class<HashMap>>[] typeParameters = hashMapClass.getTypeParameters();
        if (typeParameters.length != 0) {
            for (TypeVariable<Class<HashMap>> typeParameter : typeParameters) {
                System.out.println("Name: " + typeParameter.getName());
                System.out.println("typeName: " + typeParameter.getTypeName());
            }
        }

        Type[] genericInterfaces = hashMapClass.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            System.out.println("genericInterface: " + genericInterface);
        }

        Class<?>[] interfaces = hashMapClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("anInterface: " + anInterface);
        }

        Class<?> clazz = hashMapClass;
        while ((clazz = clazz.getSuperclass()) != null) {
            System.out.println("父类名称是： " + clazz.getCanonicalName());
        }

        for (Class<?> aClass : hashMapClass.getClasses()) {
            // 内部类
            System.out.println("classes: " + aClass.getCanonicalName());
        }
        Annotation[] annotations = MyHashMap.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解是: " + annotation);
        }

        Package aPackage = hashMapClass.getPackage();
        System.out.println("包名：" + aPackage.getName());
        System.out.println("包名2：" + aPackage);

        for (Constructor<?> constructor : hashMapClass.getConstructors()) {
            System.out.println("构造器：" + constructor.toGenericString());
        }

        for (Field field : MyHashMap.class.getFields()) {
            System.out.println("类成员变量: " + field.toGenericString());
        }

        for (Method method : hashMapClass.getMethods()) {
            System.out.println("类方法：" + method.toGenericString());
        }

        // 根据类名实例化对象
        Class<?> aClass = Class.forName("java.util.HashMap");
        aClass.newInstance();

        System.out.println(aClass);

        // 判断类或者对象是否是集合
        System.out.println("是否是集合类： " + isClassCollection(hashMapClass));
        System.out.println("是否是集合类： " + isClassCollection(String.class));
        System.out.println("是否是集合类： " + isObjectCollection(new HashMap<>()));
        System.out.println("是否是集合类： " + isObjectCollection(new String()));


    }

    private static boolean isClassCollection(Class<?> aClass) {
        return Collection.class.isAssignableFrom(aClass) || Map.class.isAssignableFrom(aClass);
    }

    public static boolean isObjectCollection(Object o) {
        return o instanceof Collection || o instanceof Map;
    }
}
