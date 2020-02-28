package com.rep.interfaces;

interface Movable {
    void setX(double x);

    void setY(double y);

    double getX();/* w w w . j a v a 2s. c o m */

    double getY();

    // A default method
    default void move(double deltaX, double deltaY) {
        double newX = getX() + deltaX;
        double newY = getY() + deltaY;
        setX(newX);
        setY(newY);
    }
}

class Pen implements Movable {
    private double x;

    private double y;

    public Pen() {
        // By default, the pen is at (0.0, 0.0)
    }

    public Pen(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return "Pen(" + x + ", " + y + ")";
    }
}

public class InterfaceWithDefaultMethodMain {
    public static void main(String[] args) {
        // Create a Pen and assign its reference to a Movable variable
        Movable p1 = new Pen();
        System.out.println(p1);

        // Move the Pen using absolute cocordinates
        p1.setX(10.0);
        p1.setY(5.0);
        System.out.println(p1);

        // Move the Pen using relative cocordinates
        p1.move(5.0, 2.0);
        System.out.println(p1);
    }
}