package com.rep.filepath.filestore;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SymbolicLink {
    public static void main(String[] args) throws IOException {
//        Path target = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\filestore\\SymbolicLink.java");
//        Path link = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\filestore\\ruanlianjie");
        Path target = FileSystems.getDefault().getPath("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\filestore\\SymbolicLink.java");
        Path link = FileSystems.getDefault().getPath("ruanlianjie");
        Path link1 = FileSystems.getDefault().getPath("ruanlianjie");
//        Files.createSymbolicLink(link, target);

//        Files
    }
}
