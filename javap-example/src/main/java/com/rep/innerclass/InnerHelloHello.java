package com.rep.innerclass;

/**
 * An inner class called InnerHello in a class called Hello:
 */
public class InnerHelloHello {

    class InnerHello {
        InnerHello() { /* www.j a v a2 s. c o m */
            System.out.println("The method call is coming from inside the class!");
        }
    }

    public InnerHelloHello() {
        // empty constructor
    }

    public static void main(String[] arguments) {
        InnerHelloHello program = new InnerHelloHello();
        InnerHelloHello.InnerHello inner = program.new InnerHello();
    }
}