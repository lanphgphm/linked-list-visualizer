package com.cs2project.linkedlistvisualizer;
import com.cs2project.linkedlistvisualizer.panels.ControlPanel;
import com.cs2project.linkedlistvisualizer.panels.DisplayPanel;
import com.cs2project.linkedlistvisualizer.panels.PanelFactory;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends javax.swing.JFrame {
    private static void showApp(){
        JFrame frame = new JFrame("Linked List Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 600);
        
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
