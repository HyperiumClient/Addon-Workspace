package com.example;

import cc.hyperium.Hyperium;
import cc.hyperium.event.EventBus;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.client.InitializationEvent;
import cc.hyperium.event.network.chat.ChatEvent;
import cc.hyperium.internal.addons.IAddon;
import com.example.commands.AddonCommand;
import net.minecraft.client.Minecraft;

// All addons must implement IAddon
public class AddonExample implements IAddon {

    /**
     * Invoked once the plugin has successfully loaded
     * {@link cc.hyperium.internal.addons.AddonMinecraftBootstrap#init}
     */
    @Override
    public void onLoad() {
        // Inform the user that the addon has loaded
        Hyperium.LOGGER.info("Successfully loaded Addon!");

        // Register the class to the EventBus
        EventBus.INSTANCE.register(this);
    }

    @InvokeEvent
    public void onInitialization(InitializationEvent event) {
        // Register a command on initialization
        Hyperium.INSTANCE.getHandlers().getCommandHandler().registerCommand(new AddonCommand());
    }

    @InvokeEvent
    public void onChatMessage(ChatEvent event) {
        // If any chat message contains "secret message!"
        if (event.getChat().getUnformattedText().contains("secret message!")) {
            //Toggle fullscreen
            Minecraft.getMinecraft().toggleFullscreen();
        }
    }

    /**
     * Invoked once the game has been closed
     * this is executed at the start of {@link net.minecraft.client.Minecraft#shutdown}
     */
    @Override
    public void onClose() {
        // Inform the user that the addon is being closed
        Hyperium.LOGGER.info("Closing...");
    }

    /**
     * Invoked on debug call. Can be used to add things into crash reports
     * <p>
     * This does not need to be overriden if it's not needed
     */
    @Override
    public void sendDebugInfo() {
    }
}
