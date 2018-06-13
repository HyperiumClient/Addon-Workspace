package com.example.overlay;

import cc.hyperium.gui.main.HyperiumOverlay;

public class OverlayExample extends HyperiumOverlay {

    public static boolean hey = false;
    public static boolean hey2 = false;

    public OverlayExample() throws Exception {
        super.addToggle("Test 1", getClass().getField("hey"));
        super.addToggle("Test 2", getClass().getField("hey2"));

        throw new NullPointerException("Test");
    }
}
