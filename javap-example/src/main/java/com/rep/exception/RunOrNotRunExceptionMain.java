package com.rep.exception;

public class RunOrNotRunExceptionMain {
    public static void main(String[] args) {
        Object chatServer = null;//from w w w.  j  ava  2  s.  c  o  m

      // Throwable -> Error/Exception -> RuntimeException/IOException....
      // exception 是必须捕获的异常
        try {
            call("Hello, how are you?");
        } catch (MyNoRunException e) {
            System.out.println("Caught a connection unavailable Exception!");
        }

        disconnectChatServer(chatServer);
    }

    private static void disconnectChatServer(Object chatServer) {
        throw new MyNoRunException2("Chat server is empty");
    }

    private static void call(String chatMessage)
            throws MyNoRunException {
        throw new MyNoRunException("Can't find the chat server");
    }

}

class MyNoRunException extends Exception {
    MyNoRunException(String message) {
        super(message);
    }
}

class MyNoRunException2 extends RuntimeException {
    MyNoRunException2(String message) {
        super(message);
    }
}