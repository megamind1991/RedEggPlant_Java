package com.rep.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 静态内部类 实现接口
 */
public class TickTockInner {
    private static String tickMessage = "Tick...";

    private static String tockMessage = "Tock...";

    public static void main(String[] args) {// w w w . j av a 2 s .c o m
        TickTockInner t = new TickTockInner();
        t.go();
    }

    private void go() {
        Timer t = new Timer(1000, new Ticker());
        t.start();

        JOptionPane.showMessageDialog(null, "Click OK to exit program");
        System.exit(0);
    }

    static class Ticker implements ActionListener {
        private boolean tick = true;

        public void actionPerformed(ActionEvent event) {
            if (tick) {
                System.out.println(tickMessage);
            }
            else {
                System.out.println(tockMessage);
            }
            tick = !tick;
        }
    }
}