package com.linkedlistvisualizer;

import javax.swing.*;
import java.awt.*;

import com.linkedlistvisualizer.components.LL.Car;
import com.linkedlistvisualizer.components.LL.LeftToRightLink;
import com.linkedlistvisualizer.components.layout.ControlPanel;
import com.linkedlistvisualizer.components.layout.DisplayPanel;

public class MainWindow extends javax.swing.JFrame {
    private static DataCenter dataCenter = new DataCenter("1, 4, 3, 2, 5, 6, 7, 8, 9, 0", "1", "0");
    private static DisplayPanel displayPanel = new DisplayPanel(dataCenter);
    private static ControlPanel controlPanel = new ControlPanel(dataCenter, displayPanel);

    public MainWindow() {

    }

    private static void showApp() {
        // MainWindow mainWindow = new MainWindow();

        JFrame frame = new JFrame("Linked List Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Styles.styleMainWindow(frame);

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        mainPanel.add(controlPanel, BorderLayout.EAST);
        mainPanel.add(displayPanel, BorderLayout.WEST);

        frame.setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> showApp());
    }
}
