package com.linkedlistvisualizer.components.layout.ControlPanel.MusicMan;


import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SoundBot {
    // public static void main(String[] args) {
    //     JFrame frame = new JFrame("LinkedList Visualizer");
    //     JButton button = new JButton("Play Sound");

    //     button.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             try {
    //                 File soundFile = new File(PlayRandomSound()); // your sound file here
    //                 AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
    //                 Clip clip = AudioSystem.getClip();
    //                 clip.open(audioIn);
    //                 clip.start();
    //             } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
    //                 ex.printStackTrace();
    //             }
    //         }
    //     });

        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(400, 400);
        // frame.setLayout(new java.awt.FlowLayout());
        // frame.add(button);
        // frame.setVisible(true);
    // }

    public static String PlayRandomSound(){
        String[] paths = {"src/assets/test.wav","src/assets/xinloi_1.wav","src/assets/CT.wav", "src/assets/LP.wav"};
        Random rand = new Random();
        int randomIndex = rand.nextInt(paths.length); 
        String randomString = paths[randomIndex]; 
        return randomString;
    }
}

