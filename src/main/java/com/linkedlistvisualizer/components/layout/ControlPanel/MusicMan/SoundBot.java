package com.linkedlistvisualizer.components.layout.ControlPanel.MusicMan;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class SoundBot {
    public static String PlayRandomSound() {
        String[] paths = { "/audio/test.wav",
                "/audio/xinloi_1.wav",
                "/audio/CT.wav",
                "/audio/LP.wav" };
        Random rand = new Random();
        int randomIndex = rand.nextInt(paths.length);
        String randomString = paths[randomIndex];
        return randomString;
    }

    public void PlaySound() {
        try {
            String sound = PlayRandomSound();
            InputStream input = this.getClass().getResourceAsStream(sound);
            BufferedInputStream buffer = new BufferedInputStream(input);

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(buffer);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}
