package com.rep.generic;

import java.util.ArrayList;
import java.util.List;

/**
  * @Description : 功能说明<br>
  * @author : 大刘
  * @Param null
  * @taskId <br>
  * @return : 通配符(?)
 * 上面有泛型的定义和赋值；当在赋值的时候，上面一节说赋值的都是为具体类型，当赋值的类型不确定的时候，我们用通配符(?)代替了：
 *
 * 如
 *
 *  List<?> unknownList;
 *   List<? extends Number> unknownNumberList;
 *   List<? super Integer> unknownBaseLineIntgerList; 
 * 在Java集合框架中，对于参数值是未知类型的容器类，
 * 只能读取其中元素，不能向其中添加元素， 因为，其类型是未知，所以编译器无法识别添加元素的类型和容器的类型是否兼容，唯一的例外是NULL
  */
public class BoxGenericDemo {
    public static void main(String[] args) {
        // 我们有个Boxs
        List<Box<Integer>> boxs = new ArrayList();

        // 直接加内容
        BoxGenericDemo.addBoxs(1, boxs);
        // 制定范形加内容
        BoxGenericDemo.<Integer> addBoxs(2, boxs);
        // 做成一个有内容的盒子 把盒子加进去
        BoxGenericDemo.addBoxs(boxs, new Box<>(3));

        // 获取一个盒子
        BoxGenericDemo.getBoxs(boxs);
    }

    public static <T> void addBoxs(List<Box<T>> boxs, Box<T> box) {
        boxs.add(box);
    }

    public static <T> void addBoxs(T t, List<Box<T>> boxes) {
        Box<T> box = new Box<>();
        box.setT(t);
        addBoxs(boxes, box);
    }

    public static <T> void getBoxs(List<Box<T>> boxes) {
        for (Box<T> box : boxes) {
            System.out.println(box.getT());
        }
    }
}

class Box<T> {
    private T t;

    public Box() {
    }

    public Box(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
