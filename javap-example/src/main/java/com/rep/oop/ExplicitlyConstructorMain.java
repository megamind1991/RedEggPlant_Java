package com.rep.oop;

class Employee1 {//  w  ww .j  a va2 s.c o m
    private String name = "Unknown";

    public Employee1(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Manager extends Employee1 {
    public Manager(String name) {
        super(name);
    }
}


public class ExplicitlyConstructorMain {
    public static void main(String[] args) {
        Manager mgr = new Manager("Edith");
        String name = mgr.getName();
        System.out.println("Manager name: " + name);
    }
}