package com.rep.hashcode;

import java.util.Objects;

public class ObjectHashMain {
    public static void main(String[] args) {
        /* w ww .java 2s.c o m */
        int hash = Objects.hash(10, 800, '\u21b9', "Hello");
        System.out.println("Hash Code is " + hash);

        // 哈希指的是一种算法 因为随机的存储 为一个值设置一个hash 那么可以在任何hash存储的时候直接定位到位置 方便查找存储

    }

}