package com.rep.base;

public class AutoCloseAbleTest {
    public static void main(String[] args) {
        // Its close() method will be called automatically */
        try (MyResource mr = new MyResource(2, false)) {
            mr.use();/*  ww  w  .  j  av  a 2 s.  co  m*/
            mr.use();
        }
//        try (MyResource mr = new MyResource(2, true)) {
//            mr.use();
//            mr.use();
//        }
    }
}


class MyResource implements AutoCloseable {
    private int score;
    private boolean errorOut;

    public MyResource(int level, boolean exceptionOnClose) {
        this.score = level;
        this.errorOut = exceptionOnClose;
        System.out.println("Creating MyResource. Level = " + level);
    }

    public void use() {
        if (score <= 0) {
            throw new RuntimeException("Low in level.");
        }
        System.out.println("Using MyResource level " + this.score);
        score--;
    }

    @Override
    public void close() {
        if (errorOut) {
            throw new RuntimeException("Error in closing");
        }
        System.out.println("Closing MyResource...");
    }
}