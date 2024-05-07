package com.linkedlistvisualizer.components.layout.Sudoku;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.text.Style;

import com.linkedlistvisualizer.Styles;
import com.linkedlistvisualizer.components.layout.Sudoku.SudokuNotiPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class SudokuPanel extends JPanel {
    private int gridSize = 9;
    private int h = 250, w = h;
    private JTextField[][] gridTextFields;
    private JPanel largeSudokuPanel, sudokuPanel;
    private SudokuNotiPanel notiPanel;
    private RandomImage randImg;
    private int sudokuMatrix[][] = new int[gridSize][gridSize];

    public SudokuPanel() {

        randImg = new RandomImage();

        gridTextFields = new JTextField[gridSize][gridSize];
        largeSudokuPanel = new JPanel(new GridBagLayout());
        sudokuPanel = new JPanel(new GridLayout(gridSize, gridSize, 0, 0));
        notiPanel = new SudokuNotiPanel();

        GridBagConstraints gbc = new GridBagConstraints();

        Styles.styleSudokuPanel(sudokuPanel, w, h);

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                gridTextFields[i][j] = new JTextField();
                // gridTextFields[i][j].setText("0");
                gridTextFields[i][j].setHorizontalAlignment(JTextField.CENTER);

                // Set background color top left, top right, bottom left, bottom right and
                // middle
                if ((i < 3 && j < 3) || (i < 3 && j > 5) || (i > 5 && j < 3) || (i > 5 && j > 5)
                        || (i > 2 && i < 6 && j > 2 && j < 6)) {
                    gridTextFields[i][j].setBackground(new Color(255, 255, 204));
                } else {
                    gridTextFields[i][j].setBackground(new Color(255, 255, 255));
                }

                // There can be a better way to set border using nested 3x3 in 3x3, however, to
                // do that we have
                // to refactor all the code for solving and printing which is tedious.
                // // Set border
                // if (i == 2 || i == 5) {
                // if (j == 2 || j == 5) {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, Color.RED),
                // BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0,
                // Color.BLACK));
                // } else if (j == 3 || j == 6) {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(0, 3, 3, 0, Color.RED),
                // BorderFactory.createMatteBorder(1, 0, 0, 1, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 3, 3, 0,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1,
                // Color.BLACK));
                // } else {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED),
                // BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1,
                // Color.BLACK));
                // }
                // } else if (i == 3 || i == 6) {
                // if (j == 2 || j == 5) {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 3, Color.RED),
                // BorderFactory.createMatteBorder(0, 1, 1, 0, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(3, 0, 0, 3,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0,
                // Color.BLACK));
                // } else if (j == 3 || j == 6) {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(3, 3, 0, 0, Color.RED),
                // BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(3, 3, 0, 0,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1,
                // Color.BLACK));
                // } else {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.RED),
                // BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1,
                // Color.BLACK));
                // }
                // } else if (i > 3 && i < 5) {
                // if (j == 2 || j == 5) {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.RED),
                // BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0,
                // Color.BLACK));
                // } else if (j == 3 || j == 6) {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.RED),
                // BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1,
                // Color.BLACK));
                // } else {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED),
                // BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
                // Color.BLACK));
                // }
                // } else {
                // if (j == 2 || j == 5) {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.RED),
                // BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0,
                // Color.BLACK));
                // } else if (j == 3 || j == 6) {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.RED),
                // BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1,
                // Color.BLACK));
                // } else {
                // // Compound border
                // gridTextFields[i][j].setBorder(new
                // CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED),
                // BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK)));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,
                // Color.RED));
                // // gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
                // Color.BLACK));
                // }
                // }

                gridTextFields[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                gridTextFields[i][j].setInputVerifier(new SudokuInputVerifier(gridTextFields[i][j]));

                sudokuPanel.add(gridTextFields[i][j]);
            }
        }

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1;
        largeSudokuPanel.add(sudokuPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        largeSudokuPanel.add(notiPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        largeSudokuPanel.add(randImg, gbc);

        add(largeSudokuPanel);
    }

    public void changeImage() {
        randImg.changeImage();
    }

    public void clearSudoku() {
        // TODO: Need threading control here
        notiPanel.setNoti("Clearing Sudoku...");

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                gridTextFields[i][j].setText("");
            }
        }
        setSudokuMatrix();

        notiPanel.setNoti("Sudoku cleared!");
    }

    public void setSudokuMatrix() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (gridTextFields[i][j].getText().equals("")) {
                    sudokuMatrix[i][j] = 0;
                } else {
                    sudokuMatrix[i][j] = Integer.parseInt(gridTextFields[i][j].getText());
                }
            }
        }
    }

    public void setSudokuMatrix(int r, int c) {
        sudokuMatrix[r][c] = 0;
        if (gridTextFields[r][c].getText().equals("")) {
            sudokuMatrix[r][c] = 0;
        } else {
            sudokuMatrix[r][c] = Integer.parseInt(gridTextFields[r][c].getText());
        }
    }

    // Import sudoku matrix to the grid
    public void importSudokuMatrix(int[][] matrix) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (matrix[i][j] == 0) {
                    gridTextFields[i][j].setText("");
                } else {
                    gridTextFields[i][j].setText(Integer.toString(matrix[i][j]));
                }
            }
        }
    }

    public void setNoti(String noti) {
        notiPanel.setNoti(noti);
        revalidate();
        repaint();
    }

    public void solveSudoku() {
        // TODO: Need threading control here
        // notiPanel.setNoti("Solving Sudoku...");

        if (!checkAllValues()) {
            notiPanel.setNoti("No solution found!");
            return;
        } else {
            solve(sudokuMatrix);
            importSudokuMatrix(sudokuMatrix);
            if (!checkFinish(sudokuMatrix)) {
                notiPanel.setNoti("No solution found!");
            } else {
                notiPanel.setNoti("Sudoku solved!");
            }
        }
    }

    // Initially, check all possible values for each cell
    public boolean checkAllValues() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (sudokuMatrix[i][j] == 0) {
                    if (find_possible_values(sudokuMatrix, i, j).length == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int[] find_possible_values(int[][] matrix, int x, int y) {
        // x = row; y = column

        checkValidRowColumn(x, y);

        // print2DArr(matrix);

        int[] result = new int[9];
        int tempCount = 0;

        for (int value = 1; value < 10; value++) {

            if ((checkValueSubmatrix(matrix, x, y, value))
                    && (checkValueRow(matrix, x, y, value))
                    && (checkValueColumn(matrix, x, y, value))) {

                result[tempCount] = value;
                tempCount += 1;

            }

        }
        return trimArr(result);
    }

    public void solve(int[][] matrix) {

        // allLoop:
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {

                if (matrix[row][column] == 0) {

                    int[] possibleValues = find_possible_values(matrix, row, column);

                    // System.out.println(Arrays.toString(possibleValues));
                    // System.out.println(row + " " + column);

                    // Note: the condition below is quite redundant, only for loop is just enough.
                    // if (possibleValues.length == 0) {
                    // return;
                    // } else {
                    for (int i = 0; i < possibleValues.length; i++) {

                        matrix[row][column] = possibleValues[i];
                        // print2DArr(matrix);

                        solve(matrix);

                        // TODO: Maybe we can bring the below condition outside of the current for loop.
                        if (checkFinish(matrix)) {
                            break;
                        } else {
                            matrix[row][column] = 0;
                            // To handle the case where there are possible values but all of those lead to
                            // wrong configuration.
                            // So we need to set the value of that cell to be zero back again and go up the
                            // recursion tree.
                            // (In short: delete current cell, go back to previous cell and try another
                            // value).
                        }
                    }
                    // }

                    return;
                    // break allLoop;
                    // So that each time call solve(), this only handle single cell.

                }

            }
        }
    }

    private static void checkValidRowColumn(int row, int column) {
        if ((row > 8) || (row < 0)) {
            throw new IllegalArgumentException("Invalid row index");
        }

        if ((column > 8) || (column < 0)) {
            throw new IllegalArgumentException("Invalid column index");
        }
    }

    // Problem with the below function: recursion call will be inefficient (check
    // everytime)
    // private static void checkValidMatrix(int[][] matrix) {
    // for (int row = 0; row < matrix.length; row++) {
    // for (int column = 0; column < matrix[row].length; column++) {
    // if (matrix[row][column] != 0) {

    // }
    // }
    // }
    // }

    private static boolean checkValueSubmatrix(int[][] matrix, int rowInd, int columnInd, int value) {

        int startRow = (int) Math.floor(rowInd / 3.0) * 3;
        int startColumn = (int) Math.floor(columnInd / 3.0) * 3;

        for (int row = startRow; row < startRow + 3; row++) {
            for (int column = startColumn; column < startColumn + 3; column++) {
                // if ((matrix[row][column] != 0)
                // && ((row != rowInd) || (column != columnInd))) {
                if (matrix[row][column] != 0) {

                    if (value == matrix[row][column]) {
                        return false;
                    }

                }
            }
        }
        return true;
    }

    private static boolean checkValueRow(int[][] matrix, int rowInd, int columnInd, int value) {

        for (int column = 0; column < 9; column++) {
            if ((matrix[rowInd][column] != 0) && (column != columnInd)) {
                if (matrix[rowInd][column] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkValueColumn(int[][] matrix, int rowInd, int columnInd, int value) {

        for (int row = 0; row < 9; row++) {
            if ((matrix[row][columnInd] != 0) && (row != rowInd)) {
                if (matrix[row][columnInd] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] trimArr(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                count += 1;
            }
        }

        int[] trimmedArr = new int[count];
        int tempCount = 0;
        for (int i = 0; i < trimmedArr.length; i++) {
            if (arr[i] != 0) {
                trimmedArr[tempCount] = arr[i];
                tempCount += 1;
            }
        }

        return trimmedArr;
    }

    private static boolean checkFinish(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private class SudokuInputVerifier extends InputVerifier {
        private JTextField input;
        private Color previousColor;

        public SudokuInputVerifier(JTextField input) {
            this.input = input;
            this.previousColor = input.getBackground();
        }

        @Override
        public boolean shouldYieldFocus(JComponent input) {
            boolean valid = verify(input);
            if (!valid) {
                // this.input.setText("");
                this.input.setBackground(new Color(255, 204, 204));
            } else {
                setSudokuMatrix(sudokuPanel.getComponentZOrder(input) / 9, sudokuPanel.getComponentZOrder(input) % 9);
                this.input.setBackground(previousColor);
            }
            return valid;
        }

        @Override
        public boolean verify(JComponent input) {
            String text = ((JTextField) input).getText();
            if (text.isEmpty()) {
                return true; // Allow empty cell
            }
            try {
                int value = Integer.parseInt(text);
                boolean flag = false;
                sudokuMatrix[sudokuPanel.getComponentZOrder(input) / 9][sudokuPanel.getComponentZOrder(input) % 9] = 0;
                int[] possibleValues = find_possible_values(sudokuMatrix, sudokuPanel.getComponentZOrder(input) / 9,
                        sudokuPanel.getComponentZOrder(input) % 9);
                for (int i = 0; i < possibleValues.length; i++) {
                    if (value == possibleValues[i]) {
                        flag = true;
                        break;
                    }
                }
                return value > 0 && value <= gridSize && flag; // Valid range 1 to gridSize
            } catch (NumberFormatException e) {
                return false; // Only allow numbers
            }
        }
    }

}
