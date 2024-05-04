package com.linkedlistvisualizer.components.LL;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;

public class VerticalLink extends JPanel {

    public VerticalLink() {
        this.setOpaque(false); // Make the panel transparent
        this.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 60); // Set the preferred width to 50 and height to 10
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        int x1 = this.getWidth() / 2, y1 = 0,
                x2 = (this.getWidth() / 2), y2 = this.getHeight() - 10;
        g2.draw(new Line2D.Double(x1, y1, x2, y2));

        // Draw the arrow head
        int arrowHeadLength = 10, arrowHeadWidth = 4;
        Polygon arrowHead = new Polygon();
        arrowHead.addPoint(x2, y2);
        arrowHead.addPoint(x2 - arrowHeadWidth, y2 - arrowHeadLength);
        arrowHead.addPoint(x2 + arrowHeadWidth, y2 - arrowHeadLength);
        g2.fill(arrowHead);
    }
}
