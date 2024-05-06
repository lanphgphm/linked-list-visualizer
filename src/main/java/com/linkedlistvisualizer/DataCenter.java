package com.linkedlistvisualizer;

public class DataCenter {
    private String array;
    private String value;
    private String index;

    public DataCenter(String array, String value, String index) {
        this.array = array;
        this.value = value;
        this.index = index;
    }

    public String getArray() {
        return this.array;
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

    public void setValue(String value) {
        this.value = value;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
