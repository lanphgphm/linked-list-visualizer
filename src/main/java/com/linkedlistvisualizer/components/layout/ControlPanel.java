package com.linkedlistvisualizer.components.layout;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Style;

import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LabelledTextInput;

public class ControlPanel extends JPanel {
    private LabelledTextInput arrayInput; 
    private LabelledTextInput valueInput; 
    private LabelledTextInput indexInput; 
    
    public ControlPanel(){
        int W = 360; // width
        int H = 600; // height
        int O = 40;  // offset

        int textW = W-O; 
        int textH = 40; 
        
        Styles.styleControlPanel(this, W, H);
        
        JPanel innerPanel = new JPanel();
        Styles.styleInnerPanel(innerPanel);
        
        // array input 
        this.arrayInput = new LabelledTextInput("List", "1, 4, 3, 2", textW, textH);
        innerPanel.add(this.arrayInput);
        
        // value input
        this.valueInput = new LabelledTextInput("Value", "1", textW, textH); 
        innerPanel.add(this.valueInput); 
        
        // index input 
        this.indexInput = new LabelledTextInput("Index (Optional)", "0", textW, textH); 
        innerPanel.add(this.indexInput); 
        
        add(innerPanel, BorderLayout.CENTER);
    }
}
