package com.rep.filepath.filestore;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileStoreAttributeView;

public class FileStoreWindow {
    public static void main(String[] args) throws IOException {
        Iterable<FileStore> fileStores = FileSystems.getDefault().getFileStores();
        for (FileStore store : fileStores) {
            long total_space = store.getTotalSpace() / 1024;
            long used_space = (store.getTotalSpace() - store.getUnallocatedSpace()) / 1024;
            long available_space = store.getUsableSpace() / 1024;
            boolean is_read_only = store.isReadOnly();

            System.out.println("--- " + store.name() + " --- " + store.type());
            System.out.println("Total space: " + total_space);
            System.out.println("Used space: " + used_space);
            System.out.println("Available space: " + available_space);
            System.out.println("Is read only? " + is_read_only);
        }

        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\nio\\BasicFileAttrView.java");
        FileStore fileStore = Files.getFileStore(path);
//        fileStore.getTotalSpace()
        FileStoreAttributeView fileStoreAttributeView = fileStore.getFileStoreAttributeView(FileStoreAttributeView.class);
//        fileStoreAttributeView.name()
    }
}
