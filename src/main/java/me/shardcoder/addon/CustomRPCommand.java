package me.shardcoder.addon;

import cc.hyperium.Hyperium;
import cc.hyperium.commands.BaseCommand;
import cc.hyperium.utils.ChatColor;

import java.util.Collections;
import java.util.List;

public class CustomRPCommand implements BaseCommand {
    @Override
    public String getName() {
        return "customrichpresence";
    }

    @Override
    public String getUsage() {
        return "/customrichpresence \n    preview [mode]\n    mode [eVowels / eAll /  sellout / reset]\n    reset";
    }

    @Override
    public void onExecute(String[] args) {
        if (args[0].equalsIgnoreCase("reset")) {
            CustomRPUpdater.customRPMode = "addon";
            Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[CustomRP] &fMode reset"), false);
            CustomRPUpdater.callCustomRPUpdate();
        } else if (args[0].equalsIgnoreCase("mode")) {
            if (args[1].equalsIgnoreCase("reset")) {
                CustomRPUpdater.customRPMode = "addon";
                Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[CustomRP] &fMode reset"), false);
                CustomRPUpdater.callCustomRPUpdate();
            } else if (args[1].equalsIgnoreCase("eVowels")) {
                CustomRPUpdater.customRPMode = "vewels";
                Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[CustomRP] &fMode set to 'eVowels'"), false);
                CustomRPUpdater.callCustomRPUpdate();
            } else if (args[1].equalsIgnoreCase("eAll")) {
                CustomRPUpdater.customRPMode = "eee";
                Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[CustomRP] &fMode set to 'eAll'"), false);
                CustomRPUpdater.callCustomRPUpdate();
            } else if (args[1].equalsIgnoreCase("sellout")) {
                CustomRPUpdater.customRPMode = "sellout";
                Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[CustomRP] &fMode set to 'sellout'"), false);
                CustomRPUpdater.callCustomRPUpdate();
            } else {
                Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(getUsage(), false);
            }
        } else if (args[0].equalsIgnoreCase("preview")) {
            if (args[1].equalsIgnoreCase("reset")) {
                Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[CustomRP] &fPreview of 'reset'\n\n" +
                        "&cHyperium\n" +
                        "&bCustomRP Addon\n" +
                        "&bPlaying a game\n" +
                        "&b[time]")
                        , false);
            } else if (args[1].equalsIgnoreCase("eVowels")) {
                Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[CustomRP] &fPreview of 'eVowels'\n\n" +
                        "&cHyperium\n" +
                        "&bCestemRP edden\n" +
                        "&beGN: [IGN but vowels are es]\n" +
                        "&b[time]")
                        , false);
            } else if (args[1].equalsIgnoreCase("eAll")) {
                Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[CustomRP] &fPreview of 'eAll'\n\n" +
                        "&cHyperium\n" +
                        "&beeeeeeee eeeee\n" +
                        "&beee: [IGN but every character is e]\n" +
                        "&b[time]")
                        , false);
            } else if (args[1].equalsIgnoreCase("sellout")) {
                Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[CustomRP] &fPreview of 'sellout'\n\n" +
                        "&cHyperium\n" +
                        "&bCustomRP Addon\n" +
                        "&bSubscribe to [IGN]\n" +
                        "&b[time]")
                , false);
            } else {
                Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(getUsage(), false);
            }
        } else {
            Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(getUsage(), false);
        }
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("crp");
    }

    @Override
    public List<String> onTabComplete(String[] args) {
        return Collections.singletonList("customrichpresence");
    }
}
