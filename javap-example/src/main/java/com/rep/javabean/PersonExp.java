package com.rep.javabean;

public class PersonExp {// w ww .ja va2 s. c o m
    private String name;

    public PersonExp() {
        this("Jane", 23);
    }

    public PersonExp(String name, int age) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}