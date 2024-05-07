package com.linkedlistvisualizer.components.layout.ControlPanel;

import javax.swing.*;

import com.linkedlistvisualizer.DataCenter;
import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LabelledTextInput;
import com.linkedlistvisualizer.components.layout.DisplayPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteButton extends JButton {
    private DataCenter dataCenter;
    private DisplayPanel displayPanel;
    private LabelledTextInput valueInput;
    private LabelledTextInput indexInput;
    private LabelledTextInput arrayInput;

    public DeleteButton(DataCenter dataCenter, DisplayPanel displayPanel, LabelledTextInput valueInput,
            LabelledTextInput indexInput,
            LabelledTextInput arrayInput) {

        this.dataCenter = dataCenter;
        this.displayPanel = displayPanel;
        this.valueInput = valueInput;
        this.indexInput = indexInput;
        this.arrayInput = arrayInput;

        setText("Delete");
        Styles.styleButton(this);

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete button clicked");

                // If both value and index are not empty, show a warning message
                if ((!valueInput.getText().equals("") && !indexInput.getText().equals(""))) {

                    JOptionPane.showMessageDialog(displayPanel,
                            "Error: Both value and index are not empty. Please enter only one of them.",
                            "ERROR: Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if the value & index input is empty, then delete the last element
                if (valueInput.getText().equals("") && indexInput.getText().equals("")) {

                    if (dataCenter.getIntArray().size() > 1) {

                        int lastCommaIndex = dataCenter.getArray().lastIndexOf(",");
                        String lastElement = dataCenter.getArray().substring(lastCommaIndex + 1,
                                dataCenter.getArray().length());
                        String updatedArray = dataCenter.getArray().substring(0, lastCommaIndex);

                        dataCenter.setArray(updatedArray);
                        dataCenter.setIntArray(updatedArray);
                        displayPanel.updateArray(dataCenter.getArray());

                        System.out.println("Deleted " + lastElement + " at the end");
                    } else {
                        String updatedArray = "";

                        dataCenter.setArray(updatedArray);
                        dataCenter.setIntArray(updatedArray);
                        displayPanel.updateArray(dataCenter.getArray());

                    }

                } else {
                    String valueInputString = valueInput.getText();
                    String indexInputString = indexInput.getText();

                    // Check if the index input is empty (default), then delete the first
                    // occurence of the specified value
                    if (indexInputString.equals("") && !valueInputString.equals("")) {

                        dataCenter.setValue(valueInputString);

                        ArrayList<Integer> intArray = dataCenter.getIntArray();
                        int indexOfValue = intArray.indexOf(Integer.parseInt(valueInputString));

                        if (indexOfValue == -1) {
                            JOptionPane.showMessageDialog(displayPanel,
                                    "Error: Value not found in the list. Please enter a valid value.",
                                    "ERROR: Invalid Input",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        intArray.remove(indexOfValue);

                        String updatedArrayStringWithBrackets = intArray.toString(); // Convert the array to a string,
                                                                                     // still have square brackets

                        String updatedArray = updatedArrayStringWithBrackets.substring(1,
                                updatedArrayStringWithBrackets.length() - 1); // Remove the square brackets

                        dataCenter.setArray(updatedArray);
                        dataCenter.setIntArray(updatedArray);
                        displayPanel.updateArray(dataCenter.getArray());
                        System.out.println("Deleted " + valueInputString + " at index " + indexOfValue);

                    } else { // Delete at the specified index

                        // Insert the value at the specified index
                        dataCenter.setIndex(indexInputString);
                        int index = Integer.parseInt(dataCenter.getIndex());

                        // Check if the index is out of range
                        if (index > dataCenter.getIntArray().size() - 1) {
                            JOptionPane.showMessageDialog(displayPanel,
                                    "Error: Index out of range for size " + dataCenter.getIntArray().size()
                                            + ". Please enter a valid index,",
                                    "ERROR: Invalid Input",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        ArrayList<Integer> intArray = dataCenter.getIntArray();
                        int value = intArray.get(index);
                        intArray.remove(index);

                        String updatedArrayStringWithBrackets = intArray.toString(); // Convert the array to a string,
                                                                                     // still have square brackets

                        String updatedArrayString = updatedArrayStringWithBrackets.substring(1,
                                updatedArrayStringWithBrackets.length() - 1); // Remove the square brackets

                        // Update the array in the dataCenter and the displayPanel
                        dataCenter.setArray(updatedArrayString);
                        dataCenter.setIntArray(updatedArrayString);
                        displayPanel.updateArray(updatedArrayString);

                        System.out.println("Updated array: " + updatedArrayString);

                        System.out.println("Deleted " + value + " at index " + index);

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
