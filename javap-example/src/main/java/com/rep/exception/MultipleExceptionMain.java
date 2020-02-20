package com.rep.exception;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public class MultipleExceptionMain {
    public static void main(String[] args) {
        try {// www.j av a  2  s .co  m
            doSomeWork();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void doSomeWork() throws IOException, InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.put("232323");
        try {
            FileOutputStream fos = new FileOutputStream("out.log");
            DataOutputStream dos = new DataOutputStream(fos);
            while (!queue.isEmpty()) {
                dos.writeUTF(queue.take());
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}