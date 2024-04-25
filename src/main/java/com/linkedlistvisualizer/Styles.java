package com.linkedlistvisualizer;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.linkedlistvisualizer.components.LL.Car;

public class Styles {
    static final Color XPBEIGE = Color.decode("#ECE9D8");
    static final Color XPBLUE = Color.decode("#3B77BC");
    static final Color XPRED = Color.decode("#DE482B");
    static final Color XPGREY = Color.decode("#827E7B");
    static final Color XPGRAY = Color.decode("#827E7B");
    static final Color XPLIGHTBLUE = Color.decode("#C7D4FE");
    static final Color XPBLACK = Color.BLACK;
    static final Color XPWHITE = Color.WHITE;
    static final Color XPYELLOW = Color.decode("#FCCF03");
    static final Color XPGREEN = Color.decode("#81C046");
    static final Color XPORANGE = Color.decode("#FFCC99");

    static final int borderSize = 4;

    static final List<Color> colors = Arrays.asList(
            XPRED, XPYELLOW, XPGREEN, XPORANGE, XPBLUE, XPLIGHTBLUE);

    private static int nextColorIdx = 0;

    public static void styleTitleBar(JPanel bar) {
        bar.setBackground(XPBLUE);
        bar.setPreferredSize(new Dimension(0, 50));
    }

    public static void styleMainWindow(JFrame frame) {
        frame.setSize(1080, 600);
        frame.setResizable(false);
        ImageIcon img = new ImageIcon("src/assets/Tan_Icon.jpg");
        frame.setIconImage(img.getImage());
    }

    public static void styleTextField(JTextField textField, int w, int h) {
        textField.setPreferredSize(new Dimension(w, h));
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, h));
    }

    public static void styleLabel(JLabel label) {
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    }

    public static void styleControlPanel(JPanel panel, int w, int h) {
        panel.setBackground(XPBEIGE);
        panel.setPreferredSize(new Dimension(w - borderSize, h));
        panel.setBorder(new CompoundBorder(
                new EmptyBorder(0, 5, 0, 0),
                new BevelBorder(BevelBorder.RAISED, XPWHITE, XPGREY)));
    }

    public static void styleInnerPanel(JPanel panel) {
        panel.setBorder(new EmptyBorder(0, borderSize, 0, 0));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(XPBEIGE);
    }

    public static void styleDisplayPanel(JPanel panel) {
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(720 - borderSize, 600));
        panel.setBorder(new CompoundBorder(
                new EmptyBorder(0, 5, 0, 0),
                new BevelBorder(BevelBorder.RAISED, XPWHITE, XPGREY)));

        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 20));
    }

    public static void setCarDataLabel(JLabel label) {
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border line = BorderFactory.createLineBorder(XPBLACK);
        Border compound = BorderFactory.createCompoundBorder(line, padding);
        label.setBorder(compound);
    }

    public static void setCarLinkLabel(JLabel label) {
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border line = BorderFactory.createLineBorder(XPBLACK);
        Border compound = BorderFactory.createCompoundBorder(line, padding);
        label.setBorder(compound);
    }

    public static void styleCar(Car car, JLabel dataLabel, JLabel linkLabel) {
        car.setLayout(new GridLayout(1, 2)); // 1 row, 2 cols
        car.setLayout(new BoxLayout(car, BoxLayout.X_AXIS));

        car.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, XPWHITE));

        Color carColor = getRandomColor();
        car.setBackground(carColor);
        System.out.println("Car with data: " + car.getData().toString() + " has color: " + carColor.toString());

        setCarDataLabel(dataLabel);
        setCarLinkLabel(linkLabel);

    }

    public static Color getRandomColor() {
        Color color = colors.get(nextColorIdx);
        nextColorIdx = (nextColorIdx + 1) % colors.size();
        return color;
    }

    public static void styleButton(JButton button) {
        button.setBackground(XPBLUE);
        button.setForeground(XPWHITE);
        button.setBorder(BorderFactory.createLineBorder(XPBLUE));
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        Border shadowBorder = BorderFactory.createLineBorder(XPGREY, 2);
        Border originalBorder = BorderFactory.createLineBorder(XPBLUE);
        Border compoundBorder = BorderFactory.createCompoundBorder(shadowBorder, originalBorder);
        button.setBorder(compoundBorder);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(XPBLUE.darker());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(XPBLUE);
            }
        });
    }
}
