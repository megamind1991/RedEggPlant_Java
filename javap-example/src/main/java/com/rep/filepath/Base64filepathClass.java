package com.rep.filepath;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64filepathClass {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[]{0x12, 0x23};
        String encode = new BASE64Encoder().encode(bytes);
        System.out.println(encode);
        byte[] bytes1 = new BASE64Decoder().decodeBuffer(encode);

        System.out.println(hexEncode(bytes));
    }

    /**
     * Encodes a byte array into a hexidecimal String.
     * @param array  The byte array to encode.
     * @return  A heidecimal String representing the byte array.
     */
    public static String hexEncode(byte[] array) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                    .substring(1, 3));
        }

        return sb.toString();
    }
}
