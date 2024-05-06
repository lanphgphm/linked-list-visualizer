package com.linkedlistvisualizer.components.layout.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.*;

public class RandomImage extends JPanel {
    private BufferedImage image, imageResized;
    private JLabel imageLabel;
    private String[] imagePaths = {
            "src/assets/0.png",
            "src/assets/1.jpg",
            "src/assets/2.png",
            "src/assets/3.png",
            "src/assets/4.png",
            "src/assets/5.png",
    };

    public RandomImage() {
        try {
            image = ImageIO.read(new File(imagePaths[generateRandomNumber()]));
            imageResized = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = imageResized.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(image, 0, 0, 100, 100, null);
            g2.dispose();
            imageLabel = new JLabel(new ImageIcon(imageResized));
            add(imageLabel);
        } catch (IOException e) {

        }
    }

    public void changeImage() {
        try {
            image = ImageIO.read(new File(imagePaths[generateRandomNumber()]));
            imageResized = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = imageResized.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(image, 0, 0, 100, 100, null);
            g2.dispose();
            imageLabel.setIcon(new ImageIcon(imageResized));
        } catch (IOException e) {

        }
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(6);
    }
}
