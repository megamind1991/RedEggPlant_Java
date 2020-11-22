package com.rep.filepath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ComparePath {
    public static void main(String[] args) {
        // 普通path比较 只是简单的值的比较并不一定有实际的文件
        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\ComparePath.java");
        Path path1 = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\testpath\\testclass.java");
        if (path.equals(path1)) {
            System.out.println("2个路径相同");
        } else {
            System.out.println("2个路径不同");
        }

        // 变成真正存在的文件进行比较
        try {
            boolean sameFile = Files.isSameFile(path, path1);
            if (sameFile) {
                System.out.println("2个路径相同");
            } else {
                System.out.println("2个路径不同");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 输出2个path的字典顺序的差  在排序的时候会很有用
        System.out.println(path.compareTo(path1));

        // 判断path是以什么开头 以什么结尾
        path.forEach(ele-> System.out.println(ele.toString()));
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(path.getName(i));
        }

        System.out.println(path.startsWith("D:"));
        System.out.println(path.startsWith("/idea"));
        System.out.println(path1.endsWith("ComparePath.java"));
        System.out.println(path.endsWith("ComparePath.java"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        for (Path path2 : path1) {
            System.out.println(path2);
        }


    }
}
