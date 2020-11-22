package com.rep.filepath.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

/**
 * DosFileAttrView
 */
public class DosFileView {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\nio\\BasicFileAttrView.java");
        try {
            DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dosFileAttributes.isReadOnly());
            System.out.println(dosFileAttributes.isHidden());
            System.out.println(dosFileAttributes.isSystem());
            System.out.println(dosFileAttributes.isArchive());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.setAttribute(path, "dos:hidden", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Files.getAttribute(path, "dos:hidden"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
