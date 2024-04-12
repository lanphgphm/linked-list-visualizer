package com.linkedlistvisualizer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Styles {
    public static void styleMainWindow(JFrame frame){
        frame.setSize(1080, 600);
        frame.setResizable(false);
        ImageIcon img = new ImageIcon("src/assets/favicon.png");
        frame.setIconImage(img.getImage());
    }
    public static void styleTextField(JTextField textField, int w, int h){
        textField.setPreferredSize(new Dimension(w, h));
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, h));
    }
    public static void styleLabel(JLabel label){
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        int topPad = 10; 
        int leftPad = 10; 
        int botPad = 0; 
        int rightPad = 0; 
        label.setBorder(BorderFactory.createEmptyBorder(topPad, leftPad, botPad, rightPad));
    }

    public static void styleControlPanel(JPanel panel, int w, int h){
        panel.setBackground(Color.pink);
        panel.setPreferredSize(new Dimension(w, h));
    }

    public static void styleInnerPanel(JPanel panel){
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.pink);
    }
}
