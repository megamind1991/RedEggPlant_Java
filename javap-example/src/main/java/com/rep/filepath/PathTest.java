package com.rep.filepath;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
        // 文件系统的获取
//        FileSystems.getDefault().
//        FileSystems.newFileSystem(URI, Map);
//        FileSystems.getFileSystem();

        File file = new File("DeflaterMain");
        Path path = Paths.get("DeflaterMain");


        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));

        // 绝对路径
        Path path1 = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\DeflaterMain.java");
        Path path2 = Paths.get("D:", "idea\\workspace\\RedEggPlant_Java\\javap-example", "src/main/java/com/rep/filepath/", "DeflaterMain.java");
        Path path22 = Paths.get("D:", "idea\\workspace\\RedEggPlant_Java\\javap-example", "src/main/java/com/rep/filepath/");

        // 根目录相对路径

        // 工作目录(项目目录)相对路径
        Path path3 = Paths.get("javap-example/src/main/java/com/rep/filepath/testpath/testclass.java");
        Path path4 = Paths.get("testpath", "testclass");

        // 通配符定义路径
        Path noNormalize = Paths.get("C:/rafaelnadal/tournaments/./2009/dummy/../BNP.txt");
        Path normalize = Paths.get("C:/rafaelnadal/tournaments/./2009/dummy/../BNP.txt").normalize();

        // URI
        Path path5 = Paths.get(URI.create("file:///rafaelnadal/tournaments/2009/BNP.txt"));
        Path path6 = Paths.get(URI.create("file:///C:/rafaelnadal/tournaments/2009/BNP.txt"));

        // 通过文件系统获取Path
        Path path7 = FileSystems.getDefault().getPath("/rafaelnadal/tournaments/2009", "BNP.txt");
        Path path8 = FileSystems.getDefault().getPath("/rafaelnadal/tournaments/2009/BNP.txt");
        Path path9 = FileSystems.getDefault().getPath("rafaelnadal/tournaments/2009", "BNP.txt");
        Path path10 = FileSystems.getDefault().
                getPath("/rafaelnadal/tournaments/./2009", "BNP.txt").normalize();

        // 通过用户home目录 用户当前目录
        Path path11 = Paths.get(System.getProperty("user.home"));
        Path path12 = Paths.get(System.getProperty("user.dir"));

        // 获取文件或者目录名
        System.out.println(path1.getFileName());
        System.out.println(path11.getFileName());
        System.out.println(path12.getFileName());

        // 获取根目录
        System.out.println(path1.getRoot());
        System.out.println(path11.getRoot());
        System.out.println(path12.getRoot());

        // 获取父目录路径
        System.out.println(path1.getParent());
        System.out.println(path11.getParent());
        System.out.println(path12.getParent());

        // path 元素大小 以及 元素循环打印
        System.out.println(path1.getNameCount());

        for (int i = 0; i < path1.getNameCount(); i++) {
            System.out.println(path1.getName(i));
        }

        // 提取path中某个子path
        System.out.println(path1.subpath(0, 5));

        // path转string
        System.out.println(path1.toString());

        // path转uri
        System.out.println(path1.toUri());

        // 相对路径转绝对路径
        System.out.println(path3.toAbsolutePath());

        // 转成真实路径
        try {
            System.out.println(path1.toRealPath());
            System.out.println(path11.toRealPath());
            System.out.println(path12.toRealPath());
            System.out.println(path3.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //output: BNP.txt
        File path_to_file = path1.toFile();

        //output: \rafaelnadal\tournaments\2009\BNP.txt
        Path file_to_path = path_to_file.toPath();
        System.out.println("Path to file name: " + path_to_file.getName());
        System.out.println("File to path: " + file_to_path.toString());


        // 统一目录下Path切换 先定义根目录path
        System.out.println(path22.resolve("PathTest.java"));
        System.out.println(path22.resolve("Base64filepathClass.java"));

        // 替换最后一级目录
        System.out.println(path1.resolveSibling("Base64filepathClass.java"));

        // 获取2个Path之间的关系
        // 注意：如果有一个路径中包含根元素，那么两个路径都必须包含根元素，否则无法创建关联 Path 对象，系统会抛异常
        Path path13 = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\testpath\\testclass.java");
        Path path14 = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\Base64filepathClass.java");
        System.out.println(path13.relativize(path14));
        System.out.println(path14.relativize(path13));

    }
}
