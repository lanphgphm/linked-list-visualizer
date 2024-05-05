package com.linkedlistvisualizer.components.layout;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.linkedlistvisualizer.DataCenter;
import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.LabelledTextInput;

// import com.linkedlistvisualizer.components.eventHandler.setList;
@SuppressWarnings("unused")
public class ControlPanel extends JPanel {
    private LabelledTextInput arrayInput;
    private LabelledTextInput valueInput;
    private LabelledTextInput indexInput;
    private DataCenter dataCenter;
    private DisplayPanel displayPanel;

    public ControlPanel(DataCenter dataCenter, DisplayPanel displayPanel) {
        this.dataCenter = dataCenter;
        this.displayPanel = displayPanel;
        int W = 360; // width
        int H = 600; // height
        int O = 40; // offset

        int textW = W - O;
        int textH = 40;

        Styles.styleControlPanel(this, W, H);

        JPanel innerPanel = new JPanel();
        Styles.styleInnerPanel(innerPanel);

        // array input
        this.arrayInput = new LabelledTextInput("List", "1, 4, 3, 2, 5, 6, 7, 8, 9", textW, textH);
        innerPanel.add(this.arrayInput);
        // button to set arrayinput
        JButton setArrayButton = new JButton("Set List");
        setArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Error: Invalid input! Please enter a list.",
                            "ERROR: Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String arrayInputString = arrayInput.getText();
                    ControlPanel.this.dataCenter.setArray(arrayInputString);
                    displayPanel.updateArray(arrayInputString, false);
                }
            }
        });
        Styles.styleButton(setArrayButton);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add a vertical spacer of 10 pixels
        innerPanel.add(setArrayButton);

        // value input
        this.valueInput = new LabelledTextInput("Value", "1", textW, textH);
        innerPanel.add(this.valueInput);
        // button to set valueinput
        JButton setValueButton = new JButton("Set Value");
        setValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (valueInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Error: Invalid input! Please enter an integer. Set Value button",
                            "ERROR: Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String valueInputString = valueInput.getText();
                    dataCenter.setValue(valueInputString);
                    String updatedArray = dataCenter.getArray() + ", " + valueInputString;
                    dataCenter.setArray(updatedArray);
                    System.out.println("Value set to: " + valueInputString);
                }
            }
        });
        Styles.styleButton(setValueButton);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add a vertical spacer of 10 pixels
        innerPanel.add(setValueButton);

        // index input
        // this.indexInput = new LabelledTextInput("Index (Optional)", "-1", textW,
        // textH);
        this.indexInput = new LabelledTextInput("Index (Optional)", "", textW, textH);
        innerPanel.add(this.indexInput);
        // button to set indexinput
        JButton setIndexButton = new JButton("Set Index");
        setIndexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indexInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Error: Invalid input! Please enter a positive integer.",
                            "ERROR: Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String indexInputString = indexInput.getText();
                    ControlPanel.this.dataCenter.setIndex(indexInputString);
                    System.out.println("Index set to: " + indexInputString);
                }
            }
        });
        Styles.styleButton(setIndexButton);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add a vertical spacer of 10 pixels
        innerPanel.add(setIndexButton);

        JPanel buttonPanel = new JPanel();
        GridBagConstraints constraints = Styles.styleButtonPanel(buttonPanel);

        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String valueInputString = valueInput.getText();
                // System.out.println("Value set to: " + valueInputString);
                // dataCenter.setIndex(indexInput.getText());
                // int index = DisplayPanel.parseStringToInt(dataCenter.getIndex());
                // System.out.println("Index set to: " + index);

                // Check if the value input is empty
                if (valueInputString.equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Error: Invalid input! Please enter an integer as a value. Insert button",
                            "ERROR: Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    dataCenter.setValue(valueInputString);
                    // Check if the index input is empty or -1 (default), then insert at the end
                    if (dataCenter.getIndex().equals("") || dataCenter.getIndex().equals("-1")) {

                        String updatedArray = dataCenter.getArray() + ", " + valueInputString;

                        dataCenter.setArray(updatedArray);
                        dataCenter.setIntArray(updatedArray);
                        displayPanel.updateArray(dataCenter.getArray(), true);

                        System.out.println("Inserted " + valueInputString + " at the end");

                    } else { // Insert at the specified index

                        int index = Integer.parseInt(dataCenter.getIndex());

                        // Check if the index is out of range
                        if (index > dataCenter.getIntArray().size()) {
                            JOptionPane.showMessageDialog(null,
                                    "Error: Index out of range for size " + dataCenter.getIntArray().size()
                                            + ". Please enter a valid index,",
                                    "ERROR: Invalid Input",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        ArrayList<Integer> intArray = dataCenter.getIntArray();
                        intArray.add(index, Integer.parseInt(valueInputString));

                        String updatedArrayStringWithBrackets = intArray.toString(); // Convert the array to a string,
                                                                                     // still have square brackets

                        String updatedArrayString = updatedArrayStringWithBrackets.substring(1,
                                updatedArrayStringWithBrackets.length() - 1); // Remove the square brackets

                        // Update the array in the dataCenter and the displayPanel
                        dataCenter.setArray(updatedArrayString);
                        dataCenter.setIntArray(updatedArrayString);
                        displayPanel.updateArray(updatedArrayString, true);

                        System.out.println("Updated array: "
                                + updatedArrayStringWithBrackets.strip().substring(1,
                                        updatedArrayStringWithBrackets.length() - 1));

                        System.out.println("Inserted " + valueInputString + " at index " + index);

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
        Styles.styleButton(insertButton);
        buttonPanel.add(insertButton, constraints);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete button clicked");

                // If both value and index are not empty, show a warning message
                if ((!valueInput.getText().equals("") && !indexInput.getText().equals(""))) {

                    JOptionPane.showMessageDialog(null,
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
                        displayPanel.updateArray(dataCenter.getArray(), true);

                        System.out.println("Deleted " + lastElement + " at the end");
                    } else {
                        String lastElement = dataCenter.getArray();
                        String updatedArray = "";

                        dataCenter.setArray(updatedArray);
                        dataCenter.setIntArray(updatedArray);
                        displayPanel.updateArray(dataCenter.getArray(), true);

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
                            JOptionPane.showMessageDialog(null,
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
                        displayPanel.updateArray(dataCenter.getArray(), true);
                        System.out.println("Deleted " + valueInputString + " at index " + indexOfValue);

                    } else { // Delete at the specified index

                        // Insert the value at the specified index
                        dataCenter.setIndex(indexInputString);
                        int index = Integer.parseInt(dataCenter.getIndex());

                        // Check if the index is out of range
                        if (index > dataCenter.getIntArray().size()) {
                            JOptionPane.showMessageDialog(null,
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
                        displayPanel.updateArray(updatedArrayString, true);

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
        Styles.styleButton(deleteButton);
        // constraints.gridy = 1;
        buttonPanel.add(deleteButton, constraints);

        add(innerPanel);

        add(buttonPanel);
    }

    public String getArrayInput() {
        return this.arrayInput.getText();
    }

    public String getValueInput() {
        return this.valueInput.getText();
    }

    public String getIndexInput() {
        return this.indexInput.getText();
    }

}
