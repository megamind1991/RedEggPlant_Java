package com.rep.generic;

import java.util.LinkedList;

import lombok.Getter;
import lombok.Setter;

public class GenericQueueClass {
    public static void main(String[] args) {
        // 有个一个空的队列
        GenericQueue<Employee> employeeGenericQueue = new GenericQueue<>();

        // 生成一个有元素的队列
        GenericQueue genericQueue = new GenericQueue<HourEmployee>();
        genericQueue.enqueue(new HourEmployee("1"));
        genericQueue.enqueue(new HourEmployee("2"));
        genericQueue.enqueue(new HourEmployee("3"));

        // 加入一个 未知的但是继承于T的类型
        employeeGenericQueue.addOtherQueue(genericQueue);

        while (employeeGenericQueue.hasEle()) {
            System.out.println(employeeGenericQueue.dequeue());
        }

    }
}

class GenericQueue<T> {
    private LinkedList<T> data = new LinkedList<T>();

    public void enqueue(T t) {
        // 进行排队
        data.addLast(t);
    }

    public T dequeue() {
        // 出列
        return data.poll();
    }

    public int getSize() {
        return data.size();
    }

    public boolean hasEle() {
        return data.size() > 0;
    }

    public void addOtherQueue(GenericQueue<? extends T> strongQueue) {
        while (strongQueue.hasEle()) {
            // 出列入列 直到没有元素
            enqueue(strongQueue.dequeue());
        }
    }
    }

@Getter
@Setter
class Employee {

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}

@Getter
@Setter
class HourEmployee extends Employee {
    public Integer beginTime;

    public Integer endTime;

    public HourEmployee(String name) {
        super(name);
    }
}