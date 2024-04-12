package com.linkedlistvisualizer.components.layout;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import com.linkedlistvisualizer.components.LabelledTextInput;

public class ControlPanel extends JPanel {
    private LabelledTextInput arrayInput; 
    private LabelledTextInput valueInput; 
    private LabelledTextInput indexInput; 
    
    public ControlPanel(){
        setBackground(Color.pink); 
        setPreferredSize(new Dimension(360, 600));
        
        JPanel innerPanel = new JPanel();
        innerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        
        // array input 
        this.arrayInput = new LabelledTextInput("List", "1, 4, 3, 2", 100, 20);
        innerPanel.add(this.arrayInput);
        
        // value input
        this.valueInput = new LabelledTextInput("Value", "1", 100, 20); 
        innerPanel.add(this.valueInput); 
        
        // index input 
        this.indexInput = new LabelledTextInput("Index (Optional)", "0", 100, 20); 
        innerPanel.add(this.indexInput); 
        
        add(innerPanel, BorderLayout.CENTER);
    }
}
