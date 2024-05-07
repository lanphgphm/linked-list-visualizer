package com.linkedlistvisualizer.components.layout.Sudoku;

import javax.swing.*;

import com.linkedlistvisualizer.Styles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearSudokuButton extends JButton {

    private SudokuPanel sudokuPanel;

    public ClearSudokuButton(SudokuPanel sudokuPanel) {
        this.sudokuPanel = sudokuPanel;
        setText("Clear Sudoku");
        Styles.styleSudokuClearButton(this);

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                sudokuPanel.changeImage();
                sudokuPanel.clearSudoku();
            }

        });
    }

    public SudokuPanel getSudokuPanel() {
        return sudokuPanel;
    }

    public void setSudokuPanel(SudokuPanel sudokuPanel) {
        this.sudokuPanel = sudokuPanel;
    }

}
