package com.rep.interfaces;

interface Swimmable {
    void swim();// ww w .j av a 2 s . c o m
}

class Fish implements Swimmable {
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    public void swim() {
        System.out.println(name + " (a fish) is swimming.");
    }
}

public class CheckImplementsIntfaceObjectCanDoSameThingByInterfaceMain {
    public static void main(String[] args) {
        // 验证可以用接口接收接口的实现类 并且正常调用方法
        Swimmable finny = new Fish("Finny");
        finny.swim();
    }
}