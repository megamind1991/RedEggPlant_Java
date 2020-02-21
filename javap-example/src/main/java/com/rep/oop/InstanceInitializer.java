package com.rep.oop;

public class InstanceInitializer {

    private static final InstanceInitializer getInsta = new InstanceInitializer();

    private static final InstanceInitializer getInsta2 = new InstanceInitializer();

    {/* w ww.j a v a2 s. c o m */
        System.out.println("Inside instance initializer 3.");
    }

    public InstanceInitializer() {
        System.out.println("Inside no-args constructor.");
    }

    {/* w ww.j a v a2 s. c o m */
        System.out.println("Inside instance initializer 1.");
    }

    static {
        System.out.println("Inside instance initializer 2.");
    }

    public static void main(String[] args) {
        try {
            System.out.println("sleep start");
            Thread.sleep(5000L);
            System.out.println("sleep end");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        InstanceInitializer ii = new InstanceInitializer();
    }
}