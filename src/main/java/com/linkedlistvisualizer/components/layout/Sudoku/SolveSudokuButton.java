package com.linkedlistvisualizer.components.layout.Sudoku;

import javax.swing.*;

import com.linkedlistvisualizer.Styles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveSudokuButton extends JButton {
    private SudokuPanel sudokuPanel;

    public SolveSudokuButton(SudokuPanel sudokuPanel) {
        this.sudokuPanel = sudokuPanel;
        setText("Solve Sudoku");
        Styles.styleSudokuSolveButton(this);

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                sudokuPanel.changeImage();
                sudokuPanel.setSudokuMatrix();
                sudokuPanel.setNoti("Solving Sudoku...");
                sudokuPanel.solveSudoku();

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
