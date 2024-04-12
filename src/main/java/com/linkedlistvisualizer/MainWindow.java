package com.linkedlistvisualizer;
import javax.swing.*;
import java.awt.*;

import com.linkedlistvisualizer.components.layout.ControlPanel;
import com.linkedlistvisualizer.components.layout.DisplayPanel;
import com.linkedlistvisualizer.components.layout.PanelFactory;

public class MainWindow extends javax.swing.JFrame {
    private static void showApp(){
        JFrame frame = new JFrame("Linked List Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Styles.styleMainWindow(frame);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);
        
        DisplayPanel displayPanel = PanelFactory.createDisplayPanel(); 
        mainPanel.add(displayPanel, BorderLayout.WEST); 
        
        ControlPanel controlPanel = PanelFactory.createControlPanel(); 
        mainPanel.add(controlPanel, BorderLayout.EAST); 
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> showApp());
    }
}
