package com.rep.directory;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.EnumSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class VisitDirectory {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\34521");
        ListTree2 listTree2 = new ListTree2();
        EnumSet<FileVisitOption> fileVisitOptions = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        try {
            Files.walkFileTree(path, fileVisitOptions, 2, listTree2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

@Getter
@Setter
class ListTree2 extends SimpleFileVisitor<Path> {

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


