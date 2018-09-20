package com.example.overlay;

import cc.hyperium.gui.main.HyperiumOverlay;
import cc.hyperium.gui.main.components.OverlayLabel;

public class OverlayExample extends HyperiumOverlay {

    public static boolean hey = false;
    
    public OverlayExample(){
            this.addToggle("example toggle", null, null, hey);
            this.getComponents().add(new OverlayLabel("Example Text"));
    }

}
