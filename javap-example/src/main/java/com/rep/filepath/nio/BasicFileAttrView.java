package com.rep.filepath.nio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttrView {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\nio\\BasicFileAttrView.java");
        // 不指定LinkOption 的话 默认是不处理符号文件连接的文件的
        //  LinkOption.NOFOLLOW_LINKS 这个枚举类型——这表示将不会处理符号链接所链接的文件，而只会处理符号链接本身的文件。
        try {
            BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println(basicFileAttributes.size());
            System.out.println(basicFileAttributes.creationTime());
            System.out.println(basicFileAttributes.lastAccessTime());
            System.out.println(basicFileAttributes.lastModifiedTime());
            System.out.println(basicFileAttributes.isDirectory());
            System.out.println(basicFileAttributes.isRegularFile());
            System.out.println(basicFileAttributes.isOther());
            System.out.println(basicFileAttributes.isSymbolicLink());
            System.out.println(basicFileAttributes.fileKey().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // [ view-name :] attribute-list
        // "*"
        // Read all basic-file-attributes.

        // "size,lastModifiedTime,lastAccessTime"
        // Reads the file size, last modified time, and last access time attributes.

        // "posix:*"
        // Read all POSIX-file-attributes.

        // "posix:permissions,owner,size"
        // Reads the POSX file permissions, owner, and file size.

        // Files.readAttributes()

        //        Files.getAttribute()

        // 变更文件的基本信息
        try {
            FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());

            // 通用方法设置属性
            Files.setAttribute(path, "basic:creationTime", fileTime);

            // 只要修改修改时间
            Files.setLastModifiedTime(path, fileTime);

            // 获取文属性视图之后设置3个时间值
            Files.getFileAttributeView(path, BasicFileAttributeView.class).setTimes(fileTime, fileTime, fileTime);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        FileSystem aDefault = FileSystems.getDefault();
        for (String supportedFileAttributeView : aDefault.supportedFileAttributeViews()) {
            System.out.println(supportedFileAttributeView);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (FileStore fileStore : aDefault.getFileStores()) {
            System.out.println(fileStore.name());
        }
    }
}
