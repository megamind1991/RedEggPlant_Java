package com.rep.generic;

import lombok.Getter;
import lombok.Setter;

public class GenericClass {
    public static void main(String[] args) {
        Wrapper<String> hello = new Wrapper<>("hello");
        System.out.println(hello.getObject());
        hello.setObject("hello2");
        System.out.println(hello.getObject());
        hello.setObject(null);
        System.out.println(hello.getObject());
    }
}

@Getter
@Setter
class Wrapper<T> {
    private T object;

    public Wrapper(T object) {
        this.object = object;
    }

//    public T getObject() {
//        return object;
//    }
//
//    public void setObject(T object) {
//        this.object = object;
//    }
}
