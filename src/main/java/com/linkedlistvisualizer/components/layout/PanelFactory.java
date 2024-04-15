package com.linkedlistvisualizer.components.layout;

import com.linkedlistvisualizer.components.linkedList.CS2LinkedList;

public class PanelFactory {
    public static ControlPanel createControlPanel() {
        return new ControlPanel();
    }

    public static DisplayPanel createDisplayPanel() {
        return new DisplayPanel();
    }

    public static DisplayPanel createDisplayPanel(CS2LinkedList<String> list) {
        return new DisplayPanel(list);
    }
}
