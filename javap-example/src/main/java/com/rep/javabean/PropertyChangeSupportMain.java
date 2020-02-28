package com.rep.javabean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Implementing a Bound Property 继承一个绑定属性
 */
public class PropertyChangeSupportMain {
    int myProperty;

    public int getMyProperty() {
        return myProperty;
    }/* from w w w . ja va2 s. c o m */

    public void setMyProperty(int newValue) {
        int oldValue = myProperty;
        myProperty = newValue;
        pceListeners.firePropertyChange("myProperty", new Integer(oldValue), new Integer(newValue));
    }

    // Create the listener list.
    PropertyChangeSupport pceListeners = new PropertyChangeSupport(this);

    // The listener list wrapper methods.
    public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
        pceListeners.addPropertyChangeListener(listener);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
        pceListeners.removePropertyChangeListener(listener);
    }
}