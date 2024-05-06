package com.linkedlistvisualizer;

import javax.swing.*;
import java.awt.*;

import com.linkedlistvisualizer.components.LL.Car;
import com.linkedlistvisualizer.components.layout.ControlPanel;
import com.linkedlistvisualizer.components.layout.DisplayPanel;
import com.linkedlistvisualizer.components.layout.SudokuPanel;

public class MainWindow extends javax.swing.JFrame {
    private static DataCenter dataCenter = new DataCenter("1, 4, 3, 2, 7, 5", "1", "0");
    private static DisplayPanel displayPanel = new DisplayPanel(dataCenter);
    private static SudokuPanel sudokuPanel = new SudokuPanel(); // Tan
    private static ControlPanel controlPanel = new ControlPanel(dataCenter, displayPanel, sudokuPanel);

    public MainWindow() {

    }

    private static void showApp() {
        // MainWindow mainWindow = new MainWindow();

        JFrame frame = new JFrame("Linked List Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Styles.styleMainWindow(frame);

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        mainPanel.add(sudokuPanel, BorderLayout.EAST);
        mainPanel.add(controlPanel, BorderLayout.CENTER);
        mainPanel.add(displayPanel, BorderLayout.WEST);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> showApp());
    }
}
