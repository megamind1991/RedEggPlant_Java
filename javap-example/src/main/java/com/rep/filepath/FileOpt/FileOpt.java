package com.rep.filepath.FileOpt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FileOpt {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOptTTT\\FileOptTTT.java");
//        Files.createFile(path);

        byte[] ball_bytes = new byte[]{
                (byte) 0x89, (byte) 0x50, (byte) 0x4e, (byte) 0x47, (byte) 0x0d, (byte) 0x0a, (byte) 0x1a, (byte) 0x0a,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x0d, (byte) 0x49, (byte) 0x48, (byte) 0x44, (byte) 0x52,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x10, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x10,
                (byte) 0x08, (byte) 0x02, (byte) 0x00,
                (byte) 0x49, (byte) 0x45, (byte) 0x4e, (byte) 0x44, (byte) 0xae, (byte) 0x42, (byte) 0x60, (byte) 0x82
        };

        path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOptTTT\\FileOptTTTP"+
                ".txt");
        String xx = "     这是啥\n   byte[] ball_bytes = new byte[]{\n" +
                "                (byte) 0x89, (byte) 0x50, (byte) 0x4e, (byte) 0x47, (byte) 0x0d, (byte) 0x0a, (byte) 0x1a, (byte) 0x0a,\n" +
                "                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x0d, (byte) 0x49, (byte) 0x48, (byte) 0x44, (byte) 0x52,\n" +
                "                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x10, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x10,\n" +
                "                (byte) 0x08, (byte) 0x02, (byte) 0x00,\n" +
                "                (byte) 0x49, (byte) 0x45, (byte) 0x4e, (byte) 0x44, (byte) 0xae, (byte) 0x42, (byte) 0x60, (byte) 0x82\n" +
                "        };";
        Files.write(path, xx.getBytes(), StandardOpenOption.APPEND);

        ArrayList<String> lines = new ArrayList<>();
        lines.add("\n");
        lines.add("Rome Masters - 5 titles in 6 years");
        lines.add("Monte Carlo Masters - 7 consecutive titles (2005-2011)");
        lines.add("Australian Open - Winner 2009");
        lines.add("Roland Garros - Winner 2005-2008, 2010, 2011");
        lines.add("Wimbledon - Winner 2008, 2010");
        lines.add("US Open - Winner 2010");

        Files.write(path, lines, StandardOpenOption.APPEND);

        Path path1 = Paths.get("C:\\Users\\34521\\Desktop\\sfzbm.png");
        byte[] bytes = Files.readAllBytes(path1);
        Path path2 = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOptTTT\\111" + System.currentTimeMillis() + ".png");
        Files.write(path2, bytes);

        // 不可读取大文件 因为jvm内存有限
        byte[] bytes1 = Files.readAllBytes(path);
        System.out.println(new String(bytes1));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<String> strings = Files.readAllLines(Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOpt\\DirectoriesOpt.java"));
        for (String string : strings) {
            System.out.println(string);
        }

        path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOptTTT\\FileOptTTTPBuffer"+
                ".txt");
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path,StandardOpenOption.APPEND);
        bufferedWriter.write(xx);
        bufferedWriter.flush();

        System.out.println("_______________________________________");
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOpt\\DirectoriesOpt.java"));
        String lineContent;
        while ((lineContent = bufferedReader.readLine()) != null) {
            System.out.println(lineContent);
        }
    }
}
