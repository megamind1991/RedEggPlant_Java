package com.rep.base;

import java.util.StringTokenizer;

public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("Hello World");
        sb1.delete(0, 6);/* from w ww . j a v a2s . c o m */
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer("Some Content");
        System.out.println(sb2);
        sb2.delete(0, sb2.length());
        System.out.println(sb2);

        StringBuffer sb3 = new StringBuffer("Hello World");
        sb3.deleteCharAt(0);
        System.out.println(sb3);

        StringBuffer sbf = new StringBuffer("StringBuffer setLength method example");
        sbf.setLength(12);
        System.out.println("StringBuffer contents: " + sbf);
        sbf.setLength(0);
        System.out.println("StringBuffer contents deleted:" + sbf);// create StringBuffer object

        sbf = new StringBuffer("This is the first line.");

        sbf.append(System.getProperty("line.separator"));

        // 键 相关值的描述
        // java.version Java 运行时环境版本
        // java.vendor Java 运行时环境供应商
        // java.vendor.url Java 供应商的 URL
        // java.home Java 安装目录
        // java.vm.specification.version Java 虚拟机规范版本
        // java.vm.specification.vendor Java 虚拟机规范供应商
        // java.vm.specification.name Java 虚拟机规范名称
        // java.vm.version Java 虚拟机实现版本
        // java.vm.vendor Java 虚拟机实现供应商
        // java.vm.name Java 虚拟机实现名称
        // java.specification.version Java 运行时环境规范版本
        // java.specification.vendor Java 运行时环境规范供应商
        // java.specification.name Java 运行时环境规范名称
        // java.class.version Java 类格式版本号
        // java.class.path Java 类路径
        // java.library.path 加载库时搜索的路径列表
        // java.io.tmpdir 默认的临时文件路径
        // java.compiler 要使用的 JIT 编译器的名称
        // java.ext.dirs 一个或多个扩展目录的路径
        // os.name 操作系统的名称
        // os.arch 操作系统的架构
        // os.version 操作系统的版本
        // file.separator 文件分隔符（在 UNIX 系统中是“/”）
        // path.separator 路径分隔符（在 UNIX 系统中是“:”）
        // line.separator 行分隔符（在 UNIX 系统中是“/n”）
        // user.name 用户的账户名称
        // user.home 用户的主目录
        // user.dir 用户的当前工作目录
        sbf.append("This is second line.");

        System.out.println(sbf);

        /* ww w.j a v a2 s.co m */
        StringBuffer sb = new StringBuffer("Hello World");
        int len = sb.length();
        System.out.println("Length of a StringBuffer object is : " + len);

        /* from w ww . j av a2 s. c o m 默认长16 */
        StringBuilder buffer1 = new StringBuilder();
        StringBuilder buffer2 = new StringBuilder(10);
        StringBuilder buffer3 = new StringBuilder("hello");

        System.out.printf("buffer1 = \"%s\"\n", buffer1);
        System.out.printf("buffer2 = \"%s\"\n", buffer2);
        System.out.printf("buffer3 = \"%s\"\n", buffer3);

        /* www. j a va2 s.c o m */
        StringBuilder buffer = new StringBuilder("Hello, how are you?");

        System.out.printf("buffer = %s\nlength = %d\ncapacity = %d\n\n", buffer.toString(), buffer.length(),
            buffer.capacity());

        buffer.ensureCapacity(75);
        System.out.printf("New capacity = %d\n\n", buffer.capacity());

        buffer.setLength(10);
        System.out.printf("New length = %d\nbuffer = %s\n", buffer.length(), buffer.toString());

        // from www .j a v a 2 s . com
        Object objectRef = "hello";
        String string = "goodbye";
        char[] charArray = {
            'a', 'b', 'c', 'd', 'e', 'f'
        };
        boolean booleanValue = true;
        char characterValue = 'K';
        int integerValue = 7;
        long longValue = 10000000;
        float floatValue = 2.5f; // f suffix indicates that 2.5 is a float
        double doubleValue = 33.333;

        buffer = new StringBuilder();

        buffer.insert(0, objectRef).insert(0, "  ") // each of these contains new line
            .insert(0, string).insert(0, "  ").insert(0, charArray).insert(0, "  ").insert(0, charArray, 3, 3)
            .insert(0, "  ").insert(0, booleanValue).insert(0, "  ").insert(0, characterValue).insert(0, "  ")
            .insert(0, integerValue).insert(0, "  ").insert(0, longValue).insert(0, "  ").insert(0, floatValue)
            .insert(0, "  ").insert(0, doubleValue);

        System.out.printf("buffer after inserts:\n%s\n\n", buffer.toString());

        buffer.deleteCharAt(10); // delete 5 in 2.5
        buffer.delete(2, 6); // delete .333 in 33.333

        System.out.printf("buffer after deletes:\n%s\n", buffer.toString());

        StringTokenizer st1, st2;

        String quote1 = "AAAA 604.43 -0.42";
        st1 = new StringTokenizer(quote1);
        System.out.println("Token 1: " + st1.nextToken());
        System.out.println("Token 2: " + st1.nextToken());
        System.out.println("Token 3: " + st1.nextToken());

        String quote2 = "AAA@60.39@0.11";
        st2 = new StringTokenizer(quote2, "@");
        System.out.println("\nToken 1: " + st2.nextToken());
        System.out.println("Token 2: " + st2.nextToken());
        System.out.println("Token 3: " + st2.nextToken());

        StringTokenizer st = new StringTokenizer("Java|StringTokenizer|Example 1", "|");
        while (st.hasMoreTokens())
            System.out.println(st.nextToken("|"));

        st = new StringTokenizer("Java StringTokenizer count Tokens Example");
        while (st.hasMoreTokens()) {
            System.out.println("Remaining Tokens : " + st.countTokens());
            System.out.println(st.nextToken());
        } // from www. j a v a 2 s . co m

        st = new StringTokenizer("Java StringTokenizer Example");
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        } /* from w ww . ja v a 2 s . c om */

        // 1. Using StringTokenizer constructor
        st1 = new StringTokenizer("Java|StringTokenizer|Example 1", "|");

        // iterate through tokens
        while (st1.hasMoreTokens())
            System.out.println(st1.nextToken());

        // 2. Using nextToken() method. Note that the new delimiter set remains the
        // default after this method call
        st2 = new StringTokenizer("Java|StringTokenizer|Example 2");

        // iterate through tokens
        while (st2.hasMoreTokens())
            System.out.println(st2.nextToken("|"));

    }
}