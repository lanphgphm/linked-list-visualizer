package com.linkedlistvisualizer.components.layout;

public class PanelFactory {
    public static ControlPanel createControlPanel(){
        return new ControlPanel(); 
    }
    
    public static DisplayPanel createDisplayPanel(){
        return new DisplayPanel(); 
    }
}
