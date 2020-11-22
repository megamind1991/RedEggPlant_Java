package com.rep.filepath.FileOpt;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoriesOpt {
    public static void main(String[] args) throws IOException {
        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path rootDirectory : rootDirectories) {
            System.out.println(rootDirectory);
        }

//        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOptTTT");
//        Files.createDirectory(path);
//
//        Path path1 = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOptTTT\\1\\2");
//        Files.createDirectories(path1);

        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath");
        DirectoryStream<Path> paths = Files.newDirectoryStream(path);
        for (Path path1 : paths) {
            System.out.println(path1);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        paths = Files.newDirectoryStream(path, "*.java");
        for (Path path1 : paths) {
            System.out.println(path1);
        }


        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        paths = Files.newDirectoryStream(path, ele -> Files.isDirectory(ele));
        for (Path path1 : paths) {
            System.out.println(path1);
        }

    }
}
