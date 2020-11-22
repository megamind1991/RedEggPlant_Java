package com.rep.Atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedRerenceTest {
    static AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<Integer>(1, 0);

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("操作线程" + Thread.currentThread().getName() + ">>>修改前数值是" + atomicInteger.getReference());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicInteger.compareAndSet(1, 2, 0, 1);
            if (b) {
                System.out.println("操作线程" + Thread.currentThread().getName() + ">>>修改后数值是" + atomicInteger.getReference());
            } else {
                System.out.println("cas修改失败");
            }
        }, "主线程");
        thread.start();

        Thread thread1 = new Thread(() -> {
            atomicInteger.compareAndSet(1, 2, 0, 1);
            System.out.println("操作线程" + Thread.currentThread().getName() + ">>>自加前数值是" + atomicInteger.getReference());
            atomicInteger.compareAndSet(2, 1, 1, 2);
            System.out.println("操作线程" + Thread.currentThread().getName() + ">>>自减后数值是" + atomicInteger.getReference());
        }, "干扰线程");
        thread1.start();
    }
}
