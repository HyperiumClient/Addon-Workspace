package com.example.overlay;

import cc.hyperium.gui.main.HyperiumOverlay;
import cc.hyperium.gui.main.components.OverlayLabel;

public class OverlayExample extends HyperiumOverlay {

    public boolean enabled = false;
    
    /**
     * Registers an example overlay to the Hyperium Config menu
     */
    public OverlayExample() {
        // Adds a toggle for "Example Toggle" and sets the variable when the toggle is changed
        this.addToggle("Example Toggle", null, null, this.enabled);
        
        // Adds a label under the toggle with this text
        this.getComponents().add(new OverlayLabel("Label example with text"));
    }
}
