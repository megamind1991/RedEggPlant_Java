package com.rep.filepath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExistOrNot {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\testpath\\testclass.java");
        System.out.println(Files.exists(path));
        System.out.println(Files.notExists(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));
        System.out.println(Files.isRegularFile(path));
        Path path1 = Paths.get("FileExistOrNot.java");

        System.out.println(Files.isSameFile(path, path1));
    }
}
