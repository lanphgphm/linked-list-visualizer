package com.linkedlistvisualizer.components.layout;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SudokuPanel extends JPanel {
    private int gridSize = 9;
    private int h = 250, w = h;
    private JTextField[][] gridTextFields;
    private JPanel sudokuPanel;
    private int sudokuMatrix[][] = new int[gridSize][gridSize];
    
    public SudokuPanel() {
        gridTextFields = new JTextField[gridSize][gridSize];
        sudokuPanel = new JPanel(new GridLayout(gridSize, gridSize, 0, 0));
        sudokuPanel.setPreferredSize(new Dimension(w, h));

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                gridTextFields[i][j] = new JTextField();
                // gridTextFields[i][j].setText("0");
                gridTextFields[i][j].setHorizontalAlignment(JTextField.CENTER);

                // Set background color top left, top right, bottom left, bottom right and middle
                if ((i < 3 && j < 3) || (i < 3 && j > 5) || (i > 5 && j < 3) || (i > 5 && j > 5) || (i > 2 && i < 6 && j > 2 && j < 6)) {
                    gridTextFields[i][j].setBackground(new Color(255, 255, 204));
                } else {
                    gridTextFields[i][j].setBackground(new Color(255, 255, 255));
                }

                // // Set border
                // if ((i + 1) % 3 == 0 && (j + 1) % 3 == 0) {
                //     gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK));
                // } else if ((i + 1) % 3 == 0) {
                //     gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
                // } else if ((j + 1) % 3 == 0) {
                //     gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
                // } else {
                //     gridTextFields[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                // }

                gridTextFields[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridTextFields[i][j].setInputVerifier(new SudokuInputVerifier(gridTextFields[i][j]));

                sudokuPanel.add(gridTextFields[i][j]);
            }
        }

        add(sudokuPanel);
    }

    public void clearSudoku() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                gridTextFields[i][j].setText("");
            }
        }
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

    //Import sudoku matrix to the grid
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

    public void solveSudoku() {
        solve(sudokuMatrix);
        importSudokuMatrix(sudokuMatrix);
    }

    //
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
                    //     return;
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
                                // To handle the case where there are possible values but all of those lead to wrong configuration.
                                // So we need to set the value of that cell to be zero back again and go up the recursion tree.
                                // (In short: delete current cell, go back to previous cell and try another value).
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

    // Problem with the below function: recursion call will be inefficient (check everytime)
    // private static void checkValidMatrix(int[][] matrix) {
    //     for (int row = 0; row < matrix.length; row++) {
    //         for (int column = 0; column < matrix[row].length; column++) {
    //             if (matrix[row][column] != 0) {
                    
    //             }
    //         }
    //     }
    // }

    private static boolean checkValueSubmatrix(int[][] matrix, int rowInd, int columnInd, int value) {

        int startRow = (int) Math.floor(rowInd / 3.0) * 3;
        int startColumn = (int) Math.floor(columnInd / 3.0) * 3;

        for (int row = startRow; row < startRow + 3; row++) {
            for (int column = startColumn; column < startColumn + 3; column++) {
                // if ((matrix[row][column] != 0) 
                //     && ((row != rowInd) || (column != columnInd))) {
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

    private void print2DArr(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }
        System.out.println();
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
                return value > 0 && value <= gridSize; // Valid range 1 to gridSize
            } catch (NumberFormatException e) {
                return false; // Only allow numbers
            }
        }
    }

}
