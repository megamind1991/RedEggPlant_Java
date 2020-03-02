package com.rep.Inheritance;

import lombok.Getter;
import lombok.Setter;

public class ShapeInheritanceClass {
    public static void main(String[] args) {
        ShapVO[] shapVOS = new ShapVO[2];
        shapVOS[0] = new Changfangxing(1, 2);
        shapVOS[1] = new YuanXing(3);

        ShapUtil.printAllShaps(shapVOS);
        ShapUtil.printAllShapsDetail(shapVOS);
    }
}

@Getter
@Setter
abstract class ShapVO {
    private String name;

    public ShapVO(String name) {
        this.name = name;
    }

    public ShapVO() {
        this.name = "unknow";
    }

    public abstract void draw();

    public abstract double getArea();

    public abstract double getPerimeter();
}

@Getter
@Setter
class Changfangxing extends ShapVO {

    private double with;

    private double length;

    /**
     * @Description : 功能说明
     * @Author : 大刘
     * @Param null
     * @Return :
     */
    public Changfangxing(final double with, final double length) {
        super("daliu长方形");
        this.with = with;
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.println("长方形绘制中。。。。。。");
    }

    @Override
    public double getArea() {
        return with * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (with + length);
    }
}

@Getter
@Setter
class YuanXing extends ShapVO {

    private double radius;

    public YuanXing(double radius) {
        super("Circle");
        this.radius = radius;
    }

    // Provide an implementation for inherited abstract draw() method
    public void draw() {
        System.out.println("Drawing a circle...");
    }

    // Provide an implementation for inherited abstract getArea() method
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Provide an implementation for inherited abstract getPerimeter() method
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }
}

class ShapUtil {

    public static void printAllShaps(ShapVO[] shapVOS) {
        for (ShapVO shapVO : shapVOS) {
            shapVO.draw();
        }
    }

    public static void printAllShapsDetail(ShapVO[] shapVOS) {
        for (ShapVO shapVO : shapVOS) {
            System.out.println(shapVO.getName());
            System.out.println(shapVO.getArea());
            System.out.println(shapVO.getPerimeter());

        }
    }
}

@Getter
@Setter
class Stick {

    private String matrial;

    private boolean curved;

    private int length;

    public Stick(String matrial, boolean curved, int length) {
        this.matrial = matrial;
        this.curved = curved;
        this.length = length;
    }
}

@Getter
@Setter
class Wooden extends Stick {

    public static final String matrial = "Wooden";

    private int lie;

    private int flex;

    public Wooden(boolean curved, int length) {
        // 可以使用静态变量直接赋值 静态变量表示现在这个类具体的特点
        super(matrial, curved, length);
    }

    public Wooden(boolean curved, int length, int lie, int flex) {
        // 如果父类没有无参构造器 这边一定要强制在最开始 掉用父类的构造器
        super(matrial, curved, length);
        this.lie = lie;
        this.flex = flex;
    }

    //    public Wooden(String matrial, boolean curved, int length) {
//        // 如果父类没有无参构造器 这边一定要强制在最开始 掉用父类的构造器
//        super(matrial, curved, length);
//
//    }
}
