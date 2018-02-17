package com.example;

import com.hcc.addons.annotations.Addon;
import com.hcc.addons.annotations.Instance;
import com.hcc.event.InitializationEvent;
import com.hcc.event.InvokeEvent;
import com.hcc.event.RenderHUDEvent;
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