package com.rep.javabean;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ImmutableJavaBeanToXmlMain {
    public static void main(String[] args) {
        MyClassImmutable o = new MyClassImmutable(123);
        try {// w w w. j a va 2 s .c o m
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("outfilename1.xml")));

            String[] propertyNames = new String[] {
                "prop"
            };
            encoder.setPersistenceDelegate(MyClassImmutable.class, new DefaultPersistenceDelegate(propertyNames));

            encoder.writeObject(o);
            encoder.close();
        }
        catch (FileNotFoundException e) {
        }
    }
}