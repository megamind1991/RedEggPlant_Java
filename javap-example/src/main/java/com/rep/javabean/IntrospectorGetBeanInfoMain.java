package com.rep.javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * javabean 使用Introspector重新设置bean的transient属性成为不可序列化
 */
public class IntrospectorGetBeanInfoMain {
    public static void main(String[] args) {
        // Create an object and set properties
        MyClass2 o = new MyClass2();
        o.setProp(1);/* www . jav a 2s. c o m */
        o.setProps(new int[] {
            1, 2, 3
        });

        try {
            // Serialize object into XML.
            // props is transient so it will not be persisted.
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("outfilename.xml")));
            encoder.writeObject(o);
            encoder.close();
        }
        catch (FileNotFoundException e) {
        }
    }

}

class MyClass2 {
    // The prop property
    int i;

    public int getProp() {
        return i;
    }

    public void setProp(int i) {
        this.i = i;
    }

    // The props property
    int[] iarray = new int[0];

    public int[] getProps() {
        return iarray;
    }

    public void setProps(int[] iarray) {
        this.iarray = iarray;
    }

    static {
        try {
            // Make the props property transient
            BeanInfo info = Introspector.getBeanInfo(MyClass2.class);
            PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; ++i) {
                PropertyDescriptor pd = propertyDescriptors[i];
                if (pd.getName().equals("props")) {
                    pd.setValue("transient", Boolean.TRUE);
                }
            }
        }
        catch (IntrospectionException e) {
        }
    }
}