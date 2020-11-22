package com.rep.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AbaProblem {

    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("操作线程" + Thread.currentThread().getName() + ">>>修改前数值是" + atomicInteger.get());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicInteger.compareAndSet(1, 2);
            if (b) {
                System.out.println("操作线程" + Thread.currentThread().getName() + ">>>修改后数值是" + atomicInteger.get());
            } else {
                System.out.println("cas修改失败");
            }
        }, "主线程");
        thread.start();

        Thread thread1 = new Thread(() -> {
            atomicInteger.incrementAndGet();
            System.out.println("操作线程" + Thread.currentThread().getName() + ">>>自加前数值是" + atomicInteger.get());
            atomicInteger.decrementAndGet();
            System.out.println("操作线程" + Thread.currentThread().getName() + ">>>自减后数值是" + atomicInteger.get());
        }, "干扰线程");
        thread1.start();
    }
}
