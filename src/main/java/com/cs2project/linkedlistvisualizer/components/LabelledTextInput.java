package com.cs2project.linkedlistvisualizer.components;
import javax.swing.*; 
import java.awt.*; 


public class LabelledTextInput extends JPanel {
    private JLabel label; 
    private JTextField textField; 
    
    public LabelledTextInput(String label, String placeholder, int w, int h){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
        setPreferredSize(new Dimension(w+20, 2*h)); 
        
        // create and config label 
        this.label = new JLabel(label); 
        this.label.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // create and config text input field 
        this.textField = new JTextField(placeholder); 
        this.textField.setPreferredSize(new Dimension(w, h));
        this.textField.setAlignmentX(Component.LEFT_ALIGNMENT); 
        
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
