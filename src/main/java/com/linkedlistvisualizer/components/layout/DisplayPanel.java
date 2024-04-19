package com.linkedlistvisualizer.components.layout;
import javax.swing.*;
import javax.swing.text.Style;

import com.linkedlistvisualizer.DataCenter;
import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LL.Car;

import java.awt.*;

public class DisplayPanel extends JPanel {
    private DataCenter dataCenter; 

    public DisplayPanel(DataCenter dataCenter){
        this.dataCenter = dataCenter;

        Styles.styleDisplayPanel(this);

        String arrayInputString = dataCenter.getArray();
        String valueInputString = dataCenter.getValue();
        String indexInputString = dataCenter.getIndex();

        int[] arrayInput = parseArrayInput(arrayInputString);
        int valueInput = parseStringToInt(valueInputString);
        int indexInput = parseStringToInt(indexInputString);
        
        Car prevCar = null; 
        for (int val: arrayInput){
            Car car = new Car(val); 
            if (prevCar != null) prevCar = car;
            this.add(car); 
            prevCar = car;
        }

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
        int[] newArray = parseArrayInput(arrayStr);
        this.removeAll(); 
        Car prevCar = null; 
        for (int val: newArray){
            Car car = new Car(val); 
            if (prevCar != null) prevCar = car;
            this.add(car); 
            prevCar = car;
        }

        this.revalidate();
        this.repaint();
    }

    

}
