package com.linkedlistvisualizer.components.layout;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

import com.linkedlistvisualizer.DataCenter;
import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LL.Car;
import com.linkedlistvisualizer.components.LL.LeftToRightLink;
import com.linkedlistvisualizer.components.LL.RightToLeftLink;
import com.linkedlistvisualizer.components.LL.VerticalLink;
import com.linkedlistvisualizer.components.LL.LeftToRightLink;

public class DisplayPanel extends JPanel {

    private static final int COMP_PER_ROW = 7;
    private GridBagConstraints constraints;

    public DisplayPanel(DataCenter dataCenter) {
        this.constraints = Styles.styleDisplayPanel(this);
        // this.constraints.anchor = GridBagConstraints.NORTHWEST;

        String arrayInputString = dataCenter.getArray();
        // uncomment to use value and index
        // String valueInputString = dataCenter.getValue();
        // String indexInputString = dataCenter.getIndex();

        renderArray(this, arrayInputString);

        this.setVisible(true);

    }

    public static int[] parseArrayInput(String arrayInputString) {
        String[] stringArray = arrayInputString.split(","); // Split the string into an array of strings
        int[] intArray = new int[stringArray.length]; // Create an array of integers with the same length

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i].trim()); // Convert each string to an integer and store it in
                                                                   // the array
        }

        return intArray;
    }

    public static int parseStringToInt(String string) {
        return Integer.parseInt(string.trim());
    }

    public void updateArray(String arrayStr) {
        this.removeAll();

        renderArray(this, arrayStr);

        this.revalidate();
        this.repaint();
    }

    public void renderArray(DisplayPanel displayPanel, String arrayStr) {
        int[] newArray = parseArrayInput(arrayStr);
        Car[] cars = new Car[newArray.length];
        for (int i = 0; i < newArray.length; i++) {
            Car car = new Car(newArray[i]);
            cars[i] = car;
        }

        for (int i = 0; i < cars.length; i++) {
            if (i < cars.length - 1) {
                cars[i].setNext(cars[i + 1]);
            }
        }

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        ArrayList<Component> components = getAllCarsAndLinks(cars);

        boolean leftToRight = true;

        for (int i = 0; i < components.size(); i++) {

            // Add a vertical link every 4 components
            if (((constraints.gridx + 1) % COMP_PER_ROW == 0) && (i != 0)) {
                if (leftToRight) {
                    constraints.gridy++;
                    displayPanel.add(new VerticalLink(), constraints);
                    constraints.gridy++;
                    leftToRight = false;
                } else {
                    constraints.gridy++;
                    displayPanel.add(new VerticalLink(), constraints);
                    constraints.gridy++;
                    leftToRight = true;

                }
            }

            if (leftToRight) {
                constraints.gridx = (i % COMP_PER_ROW);
                displayPanel.add(components.get(i), constraints);
            } else {
                constraints.gridx = (COMP_PER_ROW - 1) - (i % COMP_PER_ROW);
                displayPanel.add(components.get(i), constraints);
                constraints.gridx--;

            }
        }

    }

    public ArrayList<Component> getAllCarsAndLinks(Car[] cars) {
        int carCounter = 1;
        boolean leftToRight = true;
        ArrayList<Component> components = new ArrayList<>();
        for (Car car : cars) {
            if (car.getNext() != null) {
                if (carCounter % 4 != 0 || carCounter == 0) {
                    if (leftToRight) {
                        components.add(car);
                        carCounter++;
                        components.add(new LeftToRightLink());
                    } else {
                        components.add(car);
                        carCounter++;
                        components.add(new RightToLeftLink());
                    }
                } else {
                    if (leftToRight) {
                        components.add(car);
                        carCounter++;
                        // carCounter++;
                        leftToRight = false;
                    } else {
                        components.add(car);
                        carCounter++;
                        // carCounter++;
                        leftToRight = true;
                    }
                }

            } else {
                components.add(car);

            }
        }
        return components;
    }

}
