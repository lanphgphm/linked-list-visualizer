package com.linkedlistvisualizer.components.layout;
import javax.swing.*;
import javax.swing.text.Style;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.linkedlistvisualizer.DataCenter;
import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LabelledTextInput;
// import com.linkedlistvisualizer.components.eventHandler.setList;

public class ControlPanel extends JPanel {
    private LabelledTextInput arrayInput; 
    private LabelledTextInput valueInput; 
    private LabelledTextInput indexInput; 
    private DataCenter dataCenter;
    private DisplayPanel displayPanel;
    
    public ControlPanel(DataCenter dataCenter, DisplayPanel displayPanel){
        this.dataCenter = dataCenter;
        this.displayPanel = displayPanel;
        int W = 360; // width
        int H = 600; // height
        int O = 40;  // offset

        int textW = W-O; 
        int textH = 40; 
        
        Styles.styleControlPanel(this, W, H);
        
        JPanel innerPanel = new JPanel();
        Styles.styleInnerPanel(innerPanel);
        
        // array input 
        this.arrayInput = new LabelledTextInput("List", "1, 4, 3, 2, 7, 5", textW, textH);
        innerPanel.add(this.arrayInput);
        //button to set arrayinput 
        JButton setArrayButton = new JButton("Set List");
        setArrayButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String arrayInputString = arrayInput.getText();
                ControlPanel.this.dataCenter.setArray(arrayInputString);
                displayPanel.updateArray(arrayInputString);
            }
        });
        Styles.styleButton(setArrayButton);
        innerPanel.add(setArrayButton);
        
        // value input
        this.valueInput = new LabelledTextInput("Value", "1", textW, textH); 
        innerPanel.add(this.valueInput); 
        //button to set valueinput
        JButton setValueButton = new JButton("Set Value");
        setValueButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String valueInputString = valueInput.getText();
                ControlPanel.this.dataCenter.setValue(valueInputString);
            }
        });
        Styles.styleButton(setValueButton);
        innerPanel.add(setValueButton);
        
        // index input 
        this.indexInput = new LabelledTextInput("Index (Optional)", "0", textW, textH); 
        innerPanel.add(this.indexInput); 
        //button to set indexinput
        JButton setIndexButton = new JButton("Set Index");
        setIndexButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String indexInputString = indexInput.getText();
                ControlPanel.this.dataCenter.setIndex(indexInputString);
            }
        });
        Styles.styleButton(setIndexButton);
        innerPanel.add(setIndexButton);
        
        add(innerPanel, BorderLayout.CENTER);
    }

    public String getArrayInput(){
        return this.arrayInput.getText(); 
    }

    public String getValueInput(){
        return this.valueInput.getText(); 
    }

    public String getIndexInput(){
        return this.indexInput.getText(); 
    }


}
