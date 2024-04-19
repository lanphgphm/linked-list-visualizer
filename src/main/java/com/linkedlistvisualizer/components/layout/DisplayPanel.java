package com.linkedlistvisualizer.components.layout;
import javax.swing.*;

import com.linkedlistvisualizer.DataCenter;
import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LL.Car;

public class DisplayPanel extends JPanel {
    public DisplayPanel(DataCenter dataCenter){
        Styles.styleDisplayPanel(this);

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
            intArray[i] = Integer.parseInt(stringArray[i].trim()); // Convert each string to an integer and store it in the array
        }
    
        return intArray;
    }

    public static int parseStringToInt(String string){
        return Integer.parseInt(string.trim());
    }

    public void updateArray(String arrayStr){
        this.removeAll(); 

        renderArray(this, arrayStr);

        this.revalidate();
        this.repaint();
    }

    public void renderArray(DisplayPanel displayPanel, String arrayStr){
        int[] newArray = parseArrayInput(arrayStr);
        Car[] cars = new Car[newArray.length];
        for (int i = 0; i < newArray.length; i++){
            Car car = new Car(newArray[i]);
            cars[i] = car;
        }

        for (int i = 0; i < cars.length; i++){
            if (i < cars.length - 1){
                cars[i].setNext(cars[i+1]);
            }
            displayPanel.add(cars[i]);
        }
    }

}
