package com.linkedlistvisualizer.components.layout.ControlPanel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.linkedlistvisualizer.DataCenter;
import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LabelledTextInput;
import com.linkedlistvisualizer.components.layout.DisplayPanel;
import com.linkedlistvisualizer.components.layout.Sudoku.ClearSudokuButton;
import com.linkedlistvisualizer.components.layout.Sudoku.SolveSudokuButton;
import com.linkedlistvisualizer.components.layout.Sudoku.SudokuPanel;

// import com.linkedlistvisualizer.components.eventHandler.setList;
@SuppressWarnings("unused")
public class ControlPanel extends JPanel {
    private LabelledTextInput arrayInput;
    private LabelledTextInput valueInput;
    private LabelledTextInput indexInput;
    private DataCenter dataCenter;
    private DisplayPanel displayPanel;
    private SudokuPanel sudokuPanel;

    public ControlPanel(DataCenter dataCenter, DisplayPanel displayPanel, SudokuPanel sudokuPanel) {
        this.dataCenter = dataCenter;
        this.displayPanel = displayPanel;
        this.sudokuPanel = sudokuPanel;
        int W = 360; // width
        int H = 600; // height
        int O = 40; // offset

        int textW = W - O;
        int textH = 40;

        Styles.styleControlPanel(this, W, H);

        JPanel innerPanel = new JPanel();
        GridBagConstraints innerC = Styles.styleInnerPanel(innerPanel);

        // array input
        this.arrayInput = new LabelledTextInput("List", "1, 4, 3, 2, 5, 6, 7, 8, 9", textW, textH);
        innerC.fill = GridBagConstraints.BOTH;
        innerC.gridy = 0;
        innerC.gridx = 0;
        innerC.gridwidth = 2;
        innerPanel.add(this.arrayInput, innerC);

        // value input
        this.valueInput = new LabelledTextInput("Value", "1", textW, textH);
        innerC.gridwidth = 1;
        innerC.gridx = 0;
        innerC.fill = GridBagConstraints.BOTH;
        innerC.gridy = 2;

        innerPanel.add(this.valueInput, innerC);

        // index input
        this.indexInput = new LabelledTextInput("Index (Optional)", "", textW, textH);
        innerC.gridx = 1;
        innerC.gridwidth = 1;
        innerC.fill = GridBagConstraints.BOTH;
        innerC.gridy = 2;
        innerPanel.add(this.indexInput, innerC);

        // button to set arrayinput
        JButton setArrayButton = new SetArrayButton(dataCenter, displayPanel, arrayInput);
        innerC.gridy = 1;
        innerC.gridx = 0;
        innerC.gridwidth = 1;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(setArrayButton, innerC);

        // button to reset array
        JButton resetButton = new ResetButton(dataCenter, displayPanel, valueInput, indexInput, arrayInput);
        innerC.gridx = 1;
        innerC.gridy = 1;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(resetButton, innerC);

        // <<<<<<< HEAD

        JPanel buttonPanel = new JPanel();
        GridBagConstraints constraints = Styles.styleButtonPanel(buttonPanel);

        // Insert button
        JButton insertButton = new InsertButton(dataCenter, displayPanel, valueInput, indexInput, arrayInput);
        innerC.gridy = 3;
        innerC.gridx = 0;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(insertButton, innerC);

        // Delete button
        JButton deleteButton = new DeleteButton(dataCenter, displayPanel, valueInput, indexInput, arrayInput);
        innerC.gridy = 3;
        innerC.gridx = 1;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(deleteButton, innerC);

        // Tan
        // Clear sudoku button
        JButton clearSudokuButton = new ClearSudokuButton(sudokuPanel);
        innerC.gridy = 4;
        innerC.gridx = 0;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(clearSudokuButton, innerC);

        // Tan
        // Solve sudoku button
        JButton solveSudokuButton = new SolveSudokuButton(sudokuPanel);
        innerC.gridy = 4;
        innerC.gridx = 1;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(solveSudokuButton, innerC);
        // >>>>>>> master

        add(innerPanel);

        add(buttonPanel);
        // =======
    }

    public String getArrayInput() {
        return this.arrayInput.getText();
    }

    public String getValueInput() {
        return this.valueInput.getText();
    }

    public String getIndexInput() {
        return this.indexInput.getText();
    }

}
