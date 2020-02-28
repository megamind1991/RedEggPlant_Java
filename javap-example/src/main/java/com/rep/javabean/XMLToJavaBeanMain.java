package com.rep.javabean;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Deserializing a Bean from XML 从xml中序列化出来bean
 */
public class XMLToJavaBeanMain {
    public static void main(String[] args) throws Exception {
        try {/* w w w. ja v a 2 s .c om */
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("infilename.xml")));

            MyClassXML o = (MyClassXML) decoder.readObject();
            decoder.close();

            // Use the object
            int prop = o.getProp(); // 1
            int[] props = o.getProps(); // [1, 2, 3]
        }
        catch (FileNotFoundException e) {
        }
    }
}
