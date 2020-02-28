package com.rep.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Use interface to implement call back pattern
 */
public class TickTock {
    public static void main(String[] args) {
        Timer t = new Timer(1000, new Ticker());
        t.start();/* from www . j a v a 2 s .c om */

        // display a message box to prevent the program from ending immediately
        JOptionPane.showMessageDialog(null, "Click OK to exit program");

    }
}

class Ticker implements ActionListener {
    private boolean tick = true;

    public void actionPerformed(ActionEvent event) {
        if (tick) {
            System.out.println("Tick...");
        }
        else {
            System.out.println("Tock...");
        }
        tick = !tick;
    }
}