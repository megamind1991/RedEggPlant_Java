package com.rep.base;

import java.awt.*;

import javax.swing.*;

class DrawDotsatRandomLocations extends JComponent implements Runnable {
    Thread t;// w w w .ja v a 2s . com

    public void init() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {

            while (true) {
                Thread.sleep(200);
            }
        }
        catch (Exception e) {
        }

    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {

        int x = (int) (Math.random() * getWidth());
        int y = (int) (Math.random() * getHeight());
        g.fillRect(x, y, 2, 2);

    }
}

public class MainDrawDotsatRandomLocations {
    public static void main(String[] args) {
        DrawDotsatRandomLocations drawDotsatRandomLocations = new DrawDotsatRandomLocations();
        // Thread.r
    }
}
