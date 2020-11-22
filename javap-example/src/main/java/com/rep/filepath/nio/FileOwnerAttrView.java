package com.rep.filepath.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;

public class FileOwnerAttrView {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\nio\\FileOwnerAttrView.java");
        FileOwnerAttributeView fileAttributeView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
        System.out.println(fileAttributeView.getOwner().getName());

        UserPrincipal userPrincipal = (UserPrincipal) Files.getAttribute(path, "owner:owner");
        System.out.println(userPrincipal.getName());
    }
}
