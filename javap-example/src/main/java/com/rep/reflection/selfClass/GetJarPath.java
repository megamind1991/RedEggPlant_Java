package com.rep.reflection.selfClass;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class GetJarPath {
    public static void main(String[] args) throws IOException {
        // 获取jar包路径
        Enumeration<URL> resources =
                Thread.currentThread().getContextClassLoader().getResources("java.util.HashMap".replace(".", "/"));

        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(">>>>>>>>>>>>>");
            System.out.println(url);
            return;
        }
    }
}
