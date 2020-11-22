package com.rep.directory;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

public class DefaultLocationdirectionPath {
    public static void main(String[] args) {
        // 临时文件路径
        System.out.println(System.getProperty("java.io.tmpdir"));

        /** 文件夹的访问结果 */
        for (FileVisitResult value : FileVisitResult.values()) {
            System.out.println(value);
        }


        /** 递归访问文件夹树 */
        Path path = Paths.get("C:\\Users\\34521");
        ListTree listTree = new ListTree();

        try {
            Files.walkFileTree(path, listTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

@Getter
@Setter
class ListTree extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println(dir);
//        Objects.requireNonNull(dir);
//        if (exc != null)
//            throw exc;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {

        System.out.println(file + ">>>>  error");
//        Objects.requireNonNull(file);
        return FileVisitResult.CONTINUE;
    }
}