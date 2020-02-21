package com.rep.innerclass;

public class StaticInnerClassMain {
    // from ww w. ja v a 2 s .c om
    static String hello = "Hello";

    public static void sayHello() {
        System.out.println(hello);
    }

    static class InnerExample {
        String goodBye = "Good Bye";

        public void sayGoodBye() {
            System.out.println(this.goodBye);
        }
    }

    /**
     * Java中的内部类是在Jdk1.1版本之后增加的，内部类是Java语言中一个比较重要的概念，如果能把内部类运用好，那么会明显增强Java程序的灵活性。
     * 要想清楚static内部类和非static内部类的区别，首先要了解内部类的概念及特点，然后再进行一个全面的对比。 什么是内部类呢？简单的说就是在一个类的内部又定义了一个类，这个类就称之为内部类（Inner
     * Class）。看一个简单的例子： 内部类有以下几个主要的特点： 第一，内部类可以访问其所在类的属性（包括所在类的私有属性），内部类创建自身对象需要先创建其所在类的对象，看一个例子：
     * 第二，可以定义内部接口，且可以定义另外一个内部类实现这个内部接口，看一个例子： 第三，可以在方法体内定义一个内部类，方法体内的内部类可以完成一个基于虚方法形式的回调操作，看一个例子：
     * 第四，内部类不能定义static元素，看一个例子： 第五，内部类可以多嵌套，看一个例子：
     * static内部类是内部类中一个比较特殊的情况，Java文档中是这样描述static内部类的：一旦内部类使用static修饰，那么此时这个内部类就升级为顶级类。
     * 也就是说，除了写在一个类的内部以外，static内部类具备所有外部类的特性，看一个例子：
     * 通过这个例子我们发现，static内部类不仅可以在内部定义static元素，而且在构建对象的时候也可以一次完成。从某种意义上说，static内部类已经不算是严格意义上的内部类了。
     * 与static内部类不同，内部接口自动具备静态属性，也就是说，普通类是可以直接实现内部接口的，看一个例子：
     *
     * @param args
     */
    public static void main(String[] args) {
        StaticInnerClassMain.sayHello();
        StaticInnerClassMain.InnerExample inner = new StaticInnerClassMain.InnerExample();
        inner.sayGoodBye();
        InnerExample innerExample = new InnerExample();
        innerExample.sayGoodBye();

    }
}