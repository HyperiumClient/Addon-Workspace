package com.example;

import cc.hyperium.event.*;
import cc.hyperium.internal.addons.IAddon;
import net.minecraft.client.Minecraft;

public class AddonExample implements IAddon {

    @Override
    public void onLoad() {
        System.out.println("Successfully loaded Addon!");
        EventBus.INSTANCE.register(this);
    }

    @InvokeEvent
    private void onChatMessage(ChatEvent event) {
        if(event.getChat().getUnformattedText().contains("secret message!")) {
            Minecraft.getMinecraft().toggleFullscreen();
        }
    }

    @Override
    public void onClose() {
        System.out.println("Closing...");
    }
    
    @Override
    public void sendDebugInfo() {
    }
}
