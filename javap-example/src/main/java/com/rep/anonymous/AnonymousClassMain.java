package com.rep.anonymous;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 接口所谓的匿名类
 */
public class AnonymousClassMain {

    public static void main(String[] args) {
        String tickMessage = "Tick...";
        String tockMessage = "Tock...";
        Timer t = new Timer(1000, new ActionListener() {
            private boolean tick = true;

            public void actionPerformed(ActionEvent event) {
                if (tick) {
                    System.out.println(tickMessage);
                }
                else {// w w w . j a v a 2s . c o m
                    System.out.println(tockMessage);
                }
                tick = !tick;
            }
        });

        t.start();

        // display a message box to prevent the program
        // from ending immediately
        JOptionPane.showMessageDialog(null, "Click OK to exit program");
        System.exit(0);
    }
}