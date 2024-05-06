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
    private SudokuPanel sudokuPanel;

    public ControlPanel(DataCenter dataCenter, DisplayPanel displayPanel, SudokuPanel sudokuPanel) {
        this.dataCenter = dataCenter;
        this.displayPanel = displayPanel;
        this.sudokuPanel = sudokuPanel;
        int W = 360; // width
        int H = 600; // height
        int O = 40; // offset

        int textW = W - O;
        int textH = 40;

        Styles.styleControlPanel(this, W, H);

        JPanel innerPanel = new JPanel();
        GridBagConstraints innerC = Styles.styleInnerPanel(innerPanel);

        // array input
        this.arrayInput = new LabelledTextInput("List", "1, 4, 3, 2, 5, 6, 7, 8, 9", textW, textH);
        innerC.fill = GridBagConstraints.BOTH;
        innerC.gridy = 0;
        innerC.gridx = 0;
        innerC.gridwidth = 2;
        innerPanel.add(this.arrayInput, innerC);

        // button to set arrayinput
        JButton setArrayButton = new JButton("Set List");
        setArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String arrayInputString = arrayInput.getText();
                ControlPanel.this.dataCenter.setArray(arrayInputString);
                displayPanel.updateArray(arrayInputString, false);
            }
        });
        Styles.styleButton(setArrayButton);
        innerC.gridy = 1;
        innerC.gridx = 0;
        innerC.gridwidth = 1;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(setArrayButton, innerC);

        // button to reset array
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataCenter.setArray("");
                dataCenter.setIntArray("");
                dataCenter.setValue("");
                dataCenter.setIndex("");

                // Clear the input fields
                valueInput.setText("");
                indexInput.setText("");
                arrayInput.setText("");

                displayPanel.updateArray("", false);

            }
        });
        Styles.styleButton(resetButton);
        innerC.gridx = 1;
        innerC.gridy = 1;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(resetButton, innerC);

        // value input
        this.valueInput = new LabelledTextInput("Value", "1", textW, textH);
        innerC.gridwidth = 1;
        innerC.gridx = 0;
        innerC.fill = GridBagConstraints.BOTH;
        innerC.gridy = 2;

        innerPanel.add(this.valueInput, innerC);

        // index input
        this.indexInput = new LabelledTextInput("Index (Optional)", "", textW, textH);
        innerC.gridx = 1;
        innerC.gridwidth = 1;
        innerC.fill = GridBagConstraints.BOTH;
        innerC.gridy = 2;
        innerPanel.add(this.indexInput, innerC);

        // <<<<<<< HEAD

        JPanel buttonPanel = new JPanel();
        GridBagConstraints constraints = Styles.styleButtonPanel(buttonPanel);

        // Insert button
        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String valueInputString = valueInput.getText();
                String indexInputString = indexInput.getText();

                // Check if the value input is empty
                if (valueInputString.equals("")) {
                    JOptionPane.showMessageDialog(displayPanel,
                            "Error: Invalid input! Please enter an integer as a value. Insert button",
                            "ERROR: Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    dataCenter.setValue(valueInputString);
                    // Check if the index input is empty or -1 (default), then insert at the end
                    if (indexInputString.equals("") || indexInputString.equals("-1")) {

                        String updatedArray = dataCenter.getArray() + ", " + valueInputString;

                        dataCenter.setArray(updatedArray);
                        dataCenter.setIntArray(updatedArray);
                        displayPanel.updateArray(dataCenter.getArray(), true);

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
        // buttonPanel.add(insertButton, constraints);
        innerC.gridy = 3;
        innerC.gridx = 0;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(insertButton, innerC);

        // Delete button
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
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
                        displayPanel.updateArray(dataCenter.getArray(), true);
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
        innerC.gridy = 3;
        innerC.gridx = 1;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(deleteButton, innerC);
        // buttonPanel.add(deleteButton, constraints);

        // Tan
        // Clear sudoku button
        JButton clearSudokuButton = new JButton("Clear Sudoku");
        clearSudokuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sudokuPanel.changeImage();
                sudokuPanel.clearSudoku();
            }
        });
        Styles.styleSudokuClearButton(clearSudokuButton);
        // constraints.gridy = 2;
        // buttonPanel.add(clearSudokuButton, constraints);
        innerC.gridy = 4;
        innerC.gridx = 0;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(clearSudokuButton, innerC);

        // Tan
        // Solve sudoku button
        JButton solveSudokuButton = new JButton("Solve Sudoku");
        solveSudokuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sudokuPanel.changeImage();
                sudokuPanel.setSudokuMatrix();
                sudokuPanel.setNoti("Solving Sudoku...");
                sudokuPanel.solveSudoku();
            }
        });
        Styles.styleSudokuSolveButton(solveSudokuButton);
        // buttonPanel.add(solveSudokuButton, constraints);
        innerC.gridy = 4;
        innerC.gridx = 1;
        innerC.fill = GridBagConstraints.NONE;
        innerPanel.add(solveSudokuButton, innerC);
        // >>>>>>> master
        add(innerPanel);

        add(buttonPanel);
        // =======
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
