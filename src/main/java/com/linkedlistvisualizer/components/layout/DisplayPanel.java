package com.linkedlistvisualizer.components.layout;

import javax.swing.*;
import com.linkedlistvisualizer.Styles;
import java.awt.*;
import com.linkedlistvisualizer.components.linkedList.CS2LinkedList; // Import your CS2LinkedList class
import com.linkedlistvisualizer.components.linkedList.Node; // Import your CS2LinkedList class

public class DisplayPanel extends JPanel {
    private CS2LinkedList<String> list; // Instance variable for the linked list

    public DisplayPanel(CS2LinkedList<String> list) { // Modify constructor to accept a CS2LinkedList
        this.list = list;
        Styles.styleDisplayPanel(this);
    }

    public DisplayPanel() {
        Styles.styleDisplayPanel(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Iterate over the list and draw each node and link
        // This is just a basic example, you'll need to adjust the positions and sizes
        // to fit your needs
        Node<String> currentNode = list.getHead();
        int xPos = 50; // Starting x position for the first node
        while (currentNode != null) {
            g.drawOval(xPos, 50, 30, 30); // Draw the node as a circle
            g.drawString(currentNode.getData().toString(), xPos + 15, 75); // Draw the node's data
            if (currentNode.getNext() != null) {
                g.drawLine(xPos + 30, 65, xPos + 70, 65); // Draw a line to the next node
            }
            xPos += 70; // Move the x position for the next node
            currentNode = currentNode.getNext();
        }
    }
}