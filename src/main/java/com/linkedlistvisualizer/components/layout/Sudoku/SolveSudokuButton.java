package com.linkedlistvisualizer.components.layout.Sudoku;

import javax.swing.*;

import com.linkedlistvisualizer.Styles;

import javax.swing.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import com.linkedlistvisualizer.components.layout.ControlPanel.MusicMan.SoundBot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

                try {
                    File soundFile = new File(sound.PlayRandomSound()); // your sound file here
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    ex.printStackTrace();
                }

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
