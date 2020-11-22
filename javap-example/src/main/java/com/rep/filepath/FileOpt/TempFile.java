package com.rep.filepath.FileOpt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class TempFile {
    public static void main(String[] args) throws IOException, InterruptedException {

        // 普通创建临时目录 在默认的临时目录下
        System.out.println(System.getProperty("java.io.tmpdir"));

        Path tempDirectory = Files.createTempDirectory(null);
        System.out.println(tempDirectory);

        tempDirectory = Files.createTempDirectory("xiaogg_");
        System.out.println(tempDirectory);

        // 指定临时目录进行创建
        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOptTTT\\1");
        Path xiaogg_ = Files.createTempDirectory(path, "xiaogg_");
        System.out.println(xiaogg_);

        Path tempFile = Files.createTempFile(null, null);
        System.out.println(tempFile);
        Path tempFile1 = Files.createTempFile("xiaogg_", ".dagg");
        System.out.println(tempFile1);
        Path xiaogg_1 = Files.createTempFile(path, "xiaogg_", ".dagg");
        System.out.println(xiaogg_1);

        Path src = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOptTTT\\FileOptTTTPBuffer.txt");
        Path target = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOpt", System.currentTimeMillis() + ".cp");
//        Files.copy(src, target, REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES, NOFOLLOW_LINKS);
        FileInputStream fileInputStream = new FileInputStream(src.toFile());
        URI u = URI.create("http://www.baidu.com/");
        try (InputStream in = u.toURL().openStream()) {
            Files.copy(in, target);
        }

        // 移动文件
//        Path movefrom = FileSystems.getDefault().getPath("C:/rafaelnadal/photos/rafa_2.jpg");
//
//        try {
//            Files.move(movefrom, movefrom.resolveSibling("rafa_2_renamed.jpg"),
//                    StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            System.err.println(e);
//        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown-hook activated ...");

            //… here, cleanup/save resources
            try {
                DirectoryStream<Path> paths = Files.newDirectoryStream(path);
                for (Path path1 : paths) {
                    System.out.println("删除" + path1);
                    Files.delete(path1);
                    // 这个删除会返回一个布尔类型
                    System.out.println(Files.deleteIfExists(path1));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Shutdown-hook successfully executed ...");
        }));

        Thread.sleep(10000);

    }
}
