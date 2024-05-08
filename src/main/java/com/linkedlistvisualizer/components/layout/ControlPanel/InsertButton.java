package com.linkedlistvisualizer.components.layout.ControlPanel;

import javax.swing.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import com.linkedlistvisualizer.components.layout.ControlPanel.MusicMan.SoundBot;



import com.linkedlistvisualizer.DataCenter;
import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LabelledTextInput;
import com.linkedlistvisualizer.components.layout.DisplayPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InsertButton extends JButton {
    private DataCenter dataCenter;
    private DisplayPanel displayPanel;
    private LabelledTextInput valueInput;
    private LabelledTextInput indexInput;
    private LabelledTextInput arrayInput;

    public InsertButton(DataCenter dataCenter, DisplayPanel displayPanel, LabelledTextInput valueInput,
            LabelledTextInput indexInput,
            LabelledTextInput arrayInput) {
        this.dataCenter = dataCenter;
        this.displayPanel = displayPanel;
        this.valueInput = valueInput;
        this.indexInput = indexInput;
        this.arrayInput = arrayInput;

        Styles.styleButton(this);
        setText("Insert");
        

        SoundBot sound = new SoundBot();

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String valueInputString = valueInput.getText();
                String indexInputString = indexInput.getText();

                try {
                    File soundFile = new File(sound.PlayRandomSound()); // your sound file here
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    ex.printStackTrace();
                }







                // Check if the value input is empty
                if (valueInputString.equals("")) {
                    JOptionPane.showMessageDialog(displayPanel,
                            "Error: Invalid input! Please enter an integer as a value. Insert button",
                            "ERROR: Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    if (dataCenter.getIntArray().size() == 0) {
                        dataCenter.setArray(valueInputString);
                        dataCenter.setValue(valueInputString);
                        dataCenter.setIntArray(valueInputString);
                        displayPanel.updateArray(valueInputString);

                    } else {

                        dataCenter.setValue(valueInputString);
                        // Check if the index input is empty or -1 (default), then insert at the end
                        if (indexInputString.equals("") || indexInputString.equals("-1")) {

                            String updatedArray = dataCenter.getArray() + ", " + valueInputString;

                            dataCenter.setArray(updatedArray);
                            dataCenter.setIntArray(updatedArray);
                            displayPanel.updateArray(dataCenter.getArray());

                            System.out.println("Inserted " + valueInputString + " at the end");

                        } else { // Insert at the specified index

                            int index = Integer.parseInt(indexInputString);

                            // Check if the index is out of range
                            if (index > dataCenter.getIntArray().size()) {
                                JOptionPane.showMessageDialog(displayPanel,
                                        "Error: Index out of range for size " + dataCenter.getIntArray().size()
                                                + ". Please enter a valid index,",
                                        "ERROR: Invalid Input",
                                        JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            ArrayList<Integer> intArray = dataCenter.getIntArray();
                            intArray.add(index, Integer.parseInt(valueInputString));

                            String updatedArrayStringWithBrackets = intArray.toString(); // Convert the array to a
                                                                                         // string,
                                                                                         // still have square brackets

                            String updatedArrayString = updatedArrayStringWithBrackets.substring(1,
                                    updatedArrayStringWithBrackets.length() - 1); // Remove the square brackets

                            // Update the array in the dataCenter and the displayPanel
                            dataCenter.setArray(updatedArrayString);
                            dataCenter.setIntArray(updatedArrayString);
                            displayPanel.updateArray(updatedArrayString);

                            System.out.println("Updated array: "
                                    + updatedArrayStringWithBrackets.strip().substring(1,
                                            updatedArrayStringWithBrackets.length() - 1));

                            System.out.println("Inserted " + valueInputString + " at index " + index);

                        }
                    }
                    // Clear the input fields
                    valueInput.setText("");
                    indexInput.setText("");
                    arrayInput.setText("");

                    // Reset the index and value in the dataCenter
                    dataCenter.setIndex("");
                    dataCenter.setValue("");
                }
            }

        });
    }

    public DataCenter getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    public void setDisplayPanel(DisplayPanel displayPanel) {
        this.displayPanel = displayPanel;
    }

    public LabelledTextInput getValueInput() {
        return valueInput;
    }

    public void setValueInput(LabelledTextInput valueInput) {
        this.valueInput = valueInput;
    }

    public LabelledTextInput getIndexInput() {
        return indexInput;
    }

    public void setIndexInput(LabelledTextInput indexInput) {
        this.indexInput = indexInput;
    }

    public LabelledTextInput getArrayInput() {
        return arrayInput;
    }

    public void setArrayInput(LabelledTextInput arrayInput) {
        this.arrayInput = arrayInput;
    }

}
