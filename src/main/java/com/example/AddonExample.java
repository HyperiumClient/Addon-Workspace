package com.example;

import cc.hyperium.addons.annotations.Addon;
import cc.hyperium.addons.annotations.Instance;
import cc.hyperium.event.InitializationEvent;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.RenderHUDEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

@Addon(modid="AddonExample",version = "1.0")
public class AddonExample {

    @Instance
    public static AddonExample INSTANCE;

    private FontRenderer fontRenderer;

    @InvokeEvent
    public void init(InitializationEvent event) {
        this.fontRenderer = Minecraft.getMinecraft().fontRendererObj;
    }

    @InvokeEvent
    public void render(RenderHUDEvent event) {
        fontRenderer.drawString("FPS: " + Minecraft.getDebugFPS(), 1, 1, 0xFFFFFF);
    }

}