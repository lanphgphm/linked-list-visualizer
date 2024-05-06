package com.linkedlistvisualizer.components.LL;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class LeftToRightLink extends JPanel {

    public LeftToRightLink() {
        this.setOpaque(false); // Make the panel transparent
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 60); // Set the preferred width to 50 and height to 10
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        int x1 = 0, y1 = this.getHeight() / 2, x2 = this.getWidth(), y2 = this.getHeight() / 2;
        g2.draw(new Line2D.Double(x1, y1, x2, y2));

        // Draw the arrow head
        int arrowHeadLength = 10, arrowHeadWidth = 4;
        Polygon arrowHead = new Polygon();
        arrowHead.addPoint(x2, y2);
        arrowHead.addPoint(x2 - arrowHeadLength, y2 - arrowHeadWidth);
        arrowHead.addPoint(x2 - arrowHeadLength, y2 + arrowHeadWidth);
        g2.fill(arrowHead);
    }
}
