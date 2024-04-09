package com.cs2project.linkedlistvisualizer.panels;
import javax.swing.*;
import java.awt.*;

public class PanelFactory {
    public static ControlPanel createControlPanel(){
        return new ControlPanel(); 
    }
    
    public static DisplayPanel createDisplayPanel(){
        return new DisplayPanel(); 
    }
}
