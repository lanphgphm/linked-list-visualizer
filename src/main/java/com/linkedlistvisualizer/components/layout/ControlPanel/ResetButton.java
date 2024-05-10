package com.linkedlistvisualizer.components.layout.ControlPanel;

import javax.swing.*;

import com.linkedlistvisualizer.DataCenter;
import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LabelledTextInput;
import com.linkedlistvisualizer.components.layout.DisplayPanel;

import com.linkedlistvisualizer.components.layout.Sudoku.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JButton {

    private DataCenter dataCenter;
    private DisplayPanel displayPanel;
    private LabelledTextInput valueInput;
    private LabelledTextInput indexInput;
    private LabelledTextInput arrayInput;

    public ResetButton(DataCenter dataCenter, DisplayPanel displayPanel, LabelledTextInput valueInput,
            LabelledTextInput indexInput, LabelledTextInput arrayInput) {
        this.dataCenter = dataCenter;
        this.displayPanel = displayPanel;

        SudokuPanel sudokuPanel = new SudokuPanel();

        setText("Reset");
        Styles.styleButton(this);

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sudokuPanel.changeImage();

                dataCenter.setArray("");
                dataCenter.setIntArray("");
                dataCenter.setValue("");
                dataCenter.setIndex("");

                // Clear the input fields
                valueInput.setText("");
                indexInput.setText("");
                arrayInput.setText("");

                displayPanel.updateArray("");
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

    public LabelledTextInput getValueInput() {
        return valueInput;
    }

    public void setValueInput(LabelledTextInput valueInput) {
        this.valueInput = valueInput;
    }

    public LabelledTextInput getIndexInput() {
        return indexInput;
    }

    public void setIndexInput(LabelledTextInput indexInput) {
        this.indexInput = indexInput;
    }

    public LabelledTextInput getArrayInput() {
        return arrayInput;
    }

    public void setArrayInput(LabelledTextInput arrayInput) {
        this.arrayInput = arrayInput;
    }

}
