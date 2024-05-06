package com.linkedlistvisualizer.components.layout.ControlPanel;

import javax.swing.*;

import com.linkedlistvisualizer.DataCenter;
import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LabelledTextInput;
import com.linkedlistvisualizer.components.layout.DisplayPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetArrayButton extends JButton {
    private DataCenter dataCenter;
    private DisplayPanel displayPanel;
    private LabelledTextInput arrayInput;

    public SetArrayButton(DataCenter dataCenter, DisplayPanel displayPanel, LabelledTextInput arrayInput) {
        this.dataCenter = dataCenter;
        this.displayPanel = displayPanel;
        this.arrayInput = arrayInput;

        setText("Set List");
        Styles.styleButton(this);

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String arrayInputString = arrayInput.getText();
                dataCenter.setArray(arrayInputString);
                displayPanel.updateArray(arrayInputString);
            }

        });

    }

    public DataCenter getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    public void setDisplayPanel(DisplayPanel displayPanel) {
        this.displayPanel = displayPanel;
    }

    public LabelledTextInput getArrayInput() {
        return arrayInput;
    }

    public void setArrayInput(LabelledTextInput arrayInput) {
        this.arrayInput = arrayInput;
    }

}
