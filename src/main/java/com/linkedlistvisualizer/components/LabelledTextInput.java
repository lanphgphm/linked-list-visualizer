package com.linkedlistvisualizer.components;
import javax.swing.*;

import com.linkedlistvisualizer.Styles;

import java.awt.*; 


public class LabelledTextInput extends JPanel {
    private JLabel label; 
    private JTextField textField; 
    
    public LabelledTextInput(String label, String placeholder, int w, int h){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
        
        // create and config label 
        this.label = new JLabel(label); 
        Styles.styleLabel(this.label);
        
        // create and config text input field 
        this.textField = new JTextField(placeholder); 
        Styles.styleTextField(this.textField, w, h);
        
        add(this.label); 
        add(this.textField);
    }
    
    @Override 
    protected void paintComponent(Graphics g){
        setBackground(getParent().getBackground()); 
        super.paintComponent(g);
    }
    
    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }
}
