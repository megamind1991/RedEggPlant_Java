package com.rep.interfaces;

/**
 * 匿名内部接口类 实现接口
 */
public class AnonClass {
    public static void main(String[] args) {
        // 匿名内部接口 实现方法
        Ball b = new Ball() {
            public void hit() {
                System.out.println("You hit it!");
            }/* from ww w . j a v a2 s . c o m */
        };
        b.hit();
    }

}

interface Ball {
    void hit();
}