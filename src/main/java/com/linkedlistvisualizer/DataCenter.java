package com.linkedlistvisualizer;

import java.util.ArrayList;

import com.linkedlistvisualizer.components.layout.DisplayPanel;

public class DataCenter {
    private String array;
    private ArrayList<Integer> intArray;
    private String value;
    private String index;

    public DataCenter(String array, String value, String index) {
        this.array = array;
        this.intArray = DisplayPanel.parseArrayInput(array);
        this.value = value;
        this.index = index;

    }

    public String getArray() {
        return this.array;
    }

    public ArrayList<Integer> getIntArray() {
        return this.intArray;
    }

    public String getValue() {
        return this.value;
    }

    public String getIndex() {
        return this.index;
    }

    public void setArray(String array) {
        this.array = array;
    }

    public void setIntArray(String arrayString) {
        this.intArray = DisplayPanel.parseArrayInput(arrayString);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIndex(String index) {
        this.index = index;
    }

}
