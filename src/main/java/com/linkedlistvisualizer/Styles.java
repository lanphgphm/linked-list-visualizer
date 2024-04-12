package com.linkedlistvisualizer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Styles {
    static final Color XPBEIGE = Color.decode("#ECE9D8"); 
    static final Color XPBLUE = Color.decode("#0054E5");
    static final Color XPRED = Color.decode("#DF5330");
    static final Color XPGREY = Color.decode("#827E7B");
    static final Color XPGRAY = Color.decode("#827E7B");
    static final Color XPLIGHTBLUE = Color.decode("#C7D4FE"); 
    static final Color XPBLACK = Color.BLACK; 
    static final Color XPWHITE = Color.WHITE; 

    static final int borderSize = 4; 

    public static void styleTitleBar(JPanel bar){
        bar.setBackground(XPBLUE); 
        bar.setPreferredSize(new Dimension(0, 50));
    }

    public static void styleMainWindow(JFrame frame){
        frame.setSize(1080, 600);
        frame.setResizable(false);
        ImageIcon img = new ImageIcon("src/assets/Tan_Icon.jpg");
        frame.setIconImage(img.getImage());
    }
    public static void styleTextField(JTextField textField, int w, int h){
        textField.setPreferredSize(new Dimension(w, h));
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, h));
    }
    public static void styleLabel(JLabel label){
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    }

    public static void styleControlPanel(JPanel panel, int w, int h){
        panel.setBackground(XPBEIGE);
        panel.setPreferredSize(new Dimension(w-borderSize, h));
        panel.setBorder(new CompoundBorder(
            new EmptyBorder(0, 5, 0, 0), 
            new BevelBorder(BevelBorder.RAISED, XPWHITE, XPGREY) // TODO: this aint working 
        ));
    }

    public static void styleInnerPanel(JPanel panel){
        panel.setBorder(new EmptyBorder(0, borderSize, 0, 0));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(XPBEIGE);
    }
}
