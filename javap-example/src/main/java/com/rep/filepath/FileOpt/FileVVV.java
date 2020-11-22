package com.rep.filepath.FileOpt;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

import lombok.Getter;
import lombok.Setter;

public class FileVVV {
    public static void main(String[] args) throws IOException {
        // 文件递归4种选择
        for (FileVisitResult value : FileVisitResult.values()) {
            System.out.println(value);
        }

        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\FileOptTTT");
        FileTreeList fileTreeList = new FileTreeList(Paths.get("111.png"));
        FileTreeList fileTreeList1 = new FileTreeList(FileSystems.getDefault().getPathMatcher("glob:" + "*.java"));
        FileTreeList fileTreeList2 = new FileTreeList(FileSystems.getDefault().getPathMatcher("glob:" + "*.txt"), "这是啥");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Files.walkFileTree(path, fileTreeList);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Files.walkFileTree(path, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE, fileTreeList);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Files.walkFileTree(path, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, fileTreeList1);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Files.walkFileTree(path, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, fileTreeList2);



    }


}
@Getter
@Setter
class FileTreeList extends SimpleFileVisitor<Path> {

    private Path targetName;

    private PathMatcher match;

    private String searchContent;

    public FileTreeList(PathMatcher match) {
        this.match = match;
    }

    public FileTreeList(Path targetName) {
        this.targetName = targetName;
    }

    public FileTreeList(PathMatcher match, String searchContent) {
        this.match = match;
        this.searchContent = searchContent;
    }

    public FileTreeList(Path targetName, String searchContent) {
        this.targetName = targetName;
        this.searchContent = searchContent;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("访问文件失败" + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("正在访问文件夹" + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return isFindedFile(file);
    }

    private FileVisitResult isFindedFile(Path file) throws IOException {
        // 获取当前文件的名字以及地址
        if (targetName != null && file.getFileName() != null && targetName.equals(file.getFileName())) {
            // 找到了文件
            System.out.println("通过文件名匹配");
            System.out.println(file);
//            System.out.println(file.toRealPath());
            System.out.println("文件大小：" + Files.getAttribute(file, "basic:size"));
            searhContent(file);
            return FileVisitResult.TERMINATE;
        }

        if (match != null && file.getFileName() != null && match.matches(file.getFileName())) {
            // 找到了文件
            System.out.println("通过区域匹配查询");
            System.out.println(file);
//            System.out.println(file.toRealPath());
            System.out.println("文件大小：" + Files.getAttribute(file, "basic:size"));
            searhContent(file);
            return FileVisitResult.CONTINUE;
        }


        return FileVisitResult.CONTINUE;
    }

    private void searhContent(Path file) throws IOException {
        if (searchContent != null ) {
            BufferedReader bufferedReader = Files.newBufferedReader(file);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(searchContent)) {
                    System.out.println("找到匹配内容：" + line);
                }
            }
        }
    }

}
