package com.rep.javabean;

import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

/**
 * Implementing a Constrained Property 实现约束性属性
 */
public class VetoableChangeSupportBeanMain {
    int myProperty;

    public int getMyProperty() {
        return myProperty;
    }// from w w w. j av a 2 s. c om

    // Create the listener list. 把bean注入监听器
    VetoableChangeSupport vceListeners = new VetoableChangeSupport(this);

    // The listener list wrapper methods.
    public synchronized void addVetoableChangeListener(VetoableChangeListener listener) {
        vceListeners.addVetoableChangeListener(listener);
    }

    public synchronized void removeVetoableChangeListener(VetoableChangeListener listener) {
        vceListeners.removeVetoableChangeListener(listener);
    }

    public void setMyProperty(int newValue) throws PropertyVetoException {
        try {
            vceListeners.fireVetoableChange("myProperty", new Integer(myProperty), new Integer(newValue));
            myProperty = newValue;
        }
        catch (PropertyVetoException e) {
            throw e;
        }
    }

}