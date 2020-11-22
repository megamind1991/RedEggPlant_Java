package com.rep.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    static AtomicInteger atomicInteger = new AtomicInteger();
//    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                atomicInteger.incrementAndGet();

            }).start();
        }
        // 等待全部完成 join
        Thread.sleep(1000);
        System.out.println(atomicInteger);
    }
}
