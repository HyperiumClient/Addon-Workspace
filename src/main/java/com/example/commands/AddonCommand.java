package com.example.commands;

import cc.hyperium.commands.BaseCommand;
import cc.hyperium.commands.CommandException;
import net.minecraft.client.Minecraft;

public class AddonCommand implements BaseCommand {

    /**
     * Gets the name of the command
     */
    @Override
    public String getName() {
        return "addon_example";
    }

    /**
     * Gets the usage string for the command.
     */
    @Override
    public String getUsage() {
        return "/" + getName();
    }

    /**
     * Callback when the command is invoked
     *
     * @param args
     * @throws CommandException for errors inside the command, these errors
     *                          will log directly to the players chat (without a prefix)
     */
    @Override
    public void onExecute(String[] args) throws CommandException {
        Minecraft.getMinecraft().toggleFullscreen();
    }
}
