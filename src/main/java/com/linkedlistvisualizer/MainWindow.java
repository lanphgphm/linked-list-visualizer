package com.linkedlistvisualizer;

import javax.swing.*;
import java.awt.*;

import com.linkedlistvisualizer.components.layout.ControlPanel;
import com.linkedlistvisualizer.components.layout.DisplayPanel;
import com.linkedlistvisualizer.components.layout.PanelFactory;
import com.linkedlistvisualizer.components.linkedList.CS2LinkedList;

public class MainWindow extends javax.swing.JFrame {
    private static void showApp() {
        JFrame frame = new JFrame("Linked List Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Styles.styleMainWindow(frame);

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        CS2LinkedList<String> list = new CS2LinkedList<>(); // Create an instance of your linked list
        list.add("Tan");
        list.add("Huy");
        list.add("Sid");
        list.add("Phuong");
        list.add("Thanh");
        list.removeValue("Sid");

        DisplayPanel displayPanel = new DisplayPanel(list); // Pass the linked list to the display panel (modify the
                                                            // constructor of DisplayPanel to accept a CS2LinkedList
        mainPanel.add(displayPanel, BorderLayout.WEST);

        ControlPanel controlPanel = PanelFactory.createControlPanel();
        mainPanel.add(controlPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> showApp());
    }
}
