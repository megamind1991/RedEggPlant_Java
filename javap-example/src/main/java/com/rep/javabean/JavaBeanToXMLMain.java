package com.rep.javabean;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 将javabean写入xml
 */
public class JavaBeanToXMLMain {
    public static void main(String[] args) {
        MyClass3 o = new MyClass3();
        o.setProp(1);
        // w ww . j a v a 2 s .c om
        o.setProps(new int[] {
            1, 2, 3
        });

        try {
            // Serialize object into XML
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("outfilename.xml")));
            encoder.writeObject(o);
            encoder.close();
        }
        catch (FileNotFoundException e) {
        }
    }
}

class MyClass3 {
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
}