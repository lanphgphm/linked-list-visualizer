package com.linkedlistvisualizer.components.LL;

import javax.swing.*;
import java.awt.*;

import com.linkedlistvisualizer.Styles;

@SuppressWarnings("unused")
public class Car extends JPanel {
    private Integer data;
    private Car next;

    public Car(Integer data) {
        this.data = data;
        this.next = null;

        JLabel dataLabel = new JLabel(data.toString(), SwingConstants.CENTER);
        Styles.setCarDataLabel(dataLabel);
        add(dataLabel);

        JLabel linkLabel = new JLabel("Next: null", SwingConstants.CENTER);
        Styles.setCarLinkLabel(linkLabel);
        add(linkLabel);

        Styles.styleCar(this, dataLabel, linkLabel);
        setVisible(true);
    }

    public void setNext(Car next) {
        this.next = next;
        ((JLabel) this.getComponent(1)).setText("Next: " + (next != null ? next.data : "null"));
    }

    public Integer getData() {
        return this.data;
    }

    public Car getNext() {
        return this.next;
    }

    public Point getPosition() {
        return this.getLocation();
    }
}
