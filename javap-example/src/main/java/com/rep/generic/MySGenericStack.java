package com.rep.generic;

import java.util.ArrayList;

public class MySGenericStack {
    public static void main(String[] args) {
        double[] dd = {1.1, 2.2, 3.3, 4.4, 5.5};
        int[] ii = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        MyStack<Double> ds = new MyStack<>(5);
        MyStack<Integer> is = new MyStack<>();

        for (double v : dd) {
            ds.push(v);
        }

        try {
            while (true) {
                System.out.println(ds.pop());
            }
        } catch (StackEmptyException e) {
            System.out.println(e.getMessage());
        }

        for (int i : ii) {
            is.push(i);
        }

        try {
            while (true) {
                System.out.println(is.pop());
            }
        } catch (StackEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}

class StackEmptyException extends RuntimeException {
    public StackEmptyException() {
        // 调用单入参构造器
        this("stack is empty");
    }

    public StackEmptyException(String message) {
        super(message);
    }
}

class MyStack<T> {

    // 不会变化的东西
    private final ArrayList<T> data;

    public MyStack() {
        this.data = new ArrayList<>(10);
    }

    public MyStack(int rongliang) {
        rongliang = rongliang < 0 ? 10 : rongliang;
        this.data = new ArrayList<>(rongliang);
    }

    public void push(T t) {
        data.add(t);
    }

    public T pop() {
        if (data.size() == 0) {
            throw new StackEmptyException();
        }
        else {
            return data.remove(data.size() - 1);
        }
    }
}
