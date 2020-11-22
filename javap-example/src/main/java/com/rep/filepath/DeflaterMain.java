package com.rep.filepath;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class DeflaterMain {
    public static void main(String args[]) {
        String str = "this is a test";

        byte[] bytes = str.getBytes();

        Deflater deflater = new Deflater();

        deflater.setInput(bytes);// www. ja v a 2s . c o m

        deflater.finish();

        ByteArrayOutputStream bos = new ByteArrayOutputStream(bytes.length);

        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {
            int bytesCompressed = deflater.deflate(buffer);
            bos.write(buffer, 0, bytesCompressed);
        }

        try {
            bos.close();
        }
        catch (Exception ioe) {
            System.out.println("Error while closing the stream : " + ioe);
        }

        byte[] compressedArray = bos.toByteArray();

        System.out.println("Byte array has been compressed!");
        System.out.println("Size of original array is:" + bytes.length);
        System.out.println("Size of compressed array is:" + compressedArray.length);


      try {
        // Encode a String into bytes
        String inputString = "blahblahblah";
        byte[] input = inputString.getBytes("UTF-8");

        // Compress the bytes
        byte[] output = new byte[100];
        Deflater compresser = new Deflater();
        compresser.setInput(input);
        compresser.finish();
        int compressedDataLength = compresser.deflate(output);
        compresser.end();

        // Decompress the bytes
        Inflater decompresser = new Inflater();
        decompresser.setInput(output, 0, compressedDataLength);
        byte[] result = new byte[100];
        int resultLength = decompresser.inflate(result);
        decompresser.end();

        // Decode the bytes into a String
        String outputString = new String(result, 0, resultLength, "UTF-8");
      } catch(java.io.UnsupportedEncodingException ex) {
        // handle
      } catch (java.util.zip.DataFormatException ex) {
        // handle
      }
    }
}
