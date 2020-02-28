package com.rep.javabean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * Listing the Property Names of a Bean 列出bean的属性列表
 */
public class IntrospectorGetBeanInfoGetPropertyMain {

    public static void m() throws Exception {
        try {/* w w w .j a v a2 s . co m */
            BeanInfo bi = Introspector.getBeanInfo(MyBean.class);
            PropertyDescriptor[] pds = bi.getPropertyDescriptors();
            for (int i = 0; i < pds.length; i++) {
                // Get property name
                String propName = pds[i].getName();
                System.out.println(propName);
            }
            // class, prop1, prop2, PROP3
        }
        catch (java.beans.IntrospectionException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        IntrospectorGetBeanInfoGetPropertyMain.m();
    }
}

class MyBean {
    // Property prop1
    public String getProp1() {
        return null;
    }

    public void setProp1(String s) {
    }

    // Property prop2
    public int getProp2() {
        return 0;
    }

    public void setProp2(int i) {
    }

    // Property PROP
    public byte[] getPROP3() {
        return null;
    }

    public void setPROP3(byte[] bytes) {
    }
}