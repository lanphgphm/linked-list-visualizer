package com.linkedlistvisualizer.components.layout.Sudoku;

import javax.swing.*;

import com.linkedlistvisualizer.Styles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.linkedlistvisualizer.components.layout.ControlPanel.MusicMan.SoundBot;


public class SolveSudokuButton extends JButton {
    private SudokuPanel sudokuPanel;

    public SolveSudokuButton(SudokuPanel sudokuPanel) {
        this.sudokuPanel = sudokuPanel;
        setText("Solve Sudoku");
        Styles.styleSudokuSolveButton(this);

        SoundBot sound = new SoundBot();

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                sound.PlaySound();

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
