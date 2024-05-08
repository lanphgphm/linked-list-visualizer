package com.linkedlistvisualizer.components.layout.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.*;
import javax.imageio.*;

public class RandomImage extends JPanel {
    private BufferedImage image, imageResized;
    private JLabel imageLabel;
    private String[] imagePaths = {
            "/imgs/0.png",
            "/imgs/1.jpg",
            "/imgs/2.png",
            "/imgs/3.png",
            "/imgs/4.png",
            "/imgs/5.png",
    };

    public RandomImage() {
        try {
            URL url = this.getClass().getResource(imagePaths[generateRandomNumber()]);
            image = ImageIO.read(url);
            imageResized = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = imageResized.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(image, 0, 0, 100, 100, null);
            g2.dispose();
            imageLabel = new JLabel(new ImageIcon(imageResized));
            add(imageLabel);
        } catch (IOException e) {
            System.out.println("Error: file not found" + e.getMessage());
        }
    }

    public void changeImage() {
        try {
            URL url = this.getClass().getResource(imagePaths[generateRandomNumber()]);
            image = ImageIO.read(url);
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
