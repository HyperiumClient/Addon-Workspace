package com.example.overlay;

import cc.hyperium.gui.main.HyperiumOverlay;

public class OverlayExample extends HyperiumOverlay {

    public static boolean hey = false;
    
    public OverlayExample(){
        try {
            this.addToggle("example toggle", hey, null);
            this.getComponents().add(new OverlayLabel("Example Text"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
