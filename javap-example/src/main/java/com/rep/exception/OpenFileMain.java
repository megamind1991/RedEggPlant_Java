package com.rep.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class OpenFileMain {
    public static void main(String[] args) {//from   w w  w  .ja  v  a  2 s.c  o  m
        try {
            openFile("C:/test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void openFile(String name) throws FileNotFoundException {
        FileInputStream f = new FileInputStream(name);
    }
}