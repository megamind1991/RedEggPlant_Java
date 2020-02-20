package com.rep.oop;

import java.awt.Point;

public class PointMain {
    public static void main(String[] arguments) {
        Point pt1, pt2;/*from   ww  w .j  av  a 2 s  .  c  o  m*/
        pt1 = new Point(100, 100);
        pt2 = pt1;

        pt1.x = 200;
        pt1.y = 200;
        System.out.println("Point1: " + pt1.x + ", " + pt1.y);
        System.out.println("Point2: " + pt2.x + ", " + pt2.y);
    }
}
