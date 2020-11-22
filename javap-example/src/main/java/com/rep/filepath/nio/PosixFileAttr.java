package com.rep.filepath.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;

public class PosixFileAttr {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\nio\\FileOwnerAttrView.java");
        // windows不支持  只支持unix
        //        PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);
        //        System.out.println(posixFileAttributes.owner().getName());
        //        System.out.println(posixFileAttributes.group().getName());
        //        System.out.println(posixFileAttributes.permissions().toString());

    }
}
