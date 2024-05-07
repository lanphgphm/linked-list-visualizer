package com.linkedlistvisualizer.components.layout.Sudoku;

import com.linkedlistvisualizer.Styles;

import javax.swing.*;
import java.awt.*;

public class SudokuNotiPanel extends JPanel {
    private JLabel notiLabel;

    public SudokuNotiPanel() {
        Styles.styleSudokuNotiPanel(this);

        this.notiLabel = new JLabel();
        this.notiLabel.setText("Welcome to Sudoku Solver!");
        Styles.styleNotiLabel(this.notiLabel);

        this.add(this.notiLabel, BorderLayout.CENTER);
    }

    public void setNoti(String noti) {
        this.notiLabel.setText(noti);
    }
}