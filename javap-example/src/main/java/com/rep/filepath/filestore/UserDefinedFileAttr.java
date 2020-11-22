package com.rep.filepath.filestore;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class UserDefinedFileAttr {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\filestore\\UserDefinedFileAttr.java");
        try {
            FileStore store = Files.getFileStore(path);
            if (!store.supportsFileAttributeView(UserDefinedFileAttributeView.class)) {
                System.out.println("The user defined attributes are not supported on: " + store);
            } else {
                System.out.println("The user defined attributes are supported on: " + store);
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        UserDefinedFileAttributeView fileAttributeView = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        for (String name : fileAttributeView.list()) {
            System.out.println(fileAttributeView.size(name) + "     " + name);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        fileAttributeView.write("file.description", Charset.defaultCharset().
                encode("This file contains private information!"));

        for (String name : fileAttributeView.list()) {
            System.out.println(fileAttributeView.size(name) + "     " + name);
        }
    }
}
