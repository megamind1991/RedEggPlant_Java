package com.rep.filepath.filewatch;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileWatchService {
    public static void main(String[] args) throws IOException, InterruptedException {

        Path path = Paths.get("D:\\idea\\workspace\\RedEggPlant_Java\\javap-example\\src\\main\\java\\com\\rep\\filepath\\filewatchtest");
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE
                    , StandardWatchEventKinds.ENTRY_MODIFY
                    , StandardWatchEventKinds.ENTRY_DELETE);

            while (true) {
                // 拉取一个没有就返回null
                //                watchService.poll();
                //                // 拉取一个 没有就等待一定时间后 在拉去 如果还没有就返回null
                //                watchService.poll(60, TimeUnit.SECONDS);
                // 阻塞等待key
                WatchKey watchKey = watchService.take();

                for (WatchEvent<?> pollEvent : watchKey.pollEvents()) {
                    Path context = (Path) pollEvent.context();
                    System.out.println("当前监视到的文件是" + context);
                    System.out.println("当前触发的事件是：" + pollEvent.kind().name());
                }

                // 因为使用了take将监控线程阻塞了 这边直接重置 就可以释放阻塞了
                watchKey.reset();

                if (!watchKey.isValid()) {
                    break;
                }
            }
        }
    }
}
