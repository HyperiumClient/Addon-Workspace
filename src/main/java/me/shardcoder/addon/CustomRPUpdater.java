package me.shardcoder.addon;

import cc.hyperium.gui.settings.items.GeneralSetting;
import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.entities.RichPresence;
import net.minecraft.client.Minecraft;

import java.time.OffsetDateTime;

public class CustomRPUpdater {
    private static IPCClient client;
    public static String customRPMode = "addon";

    public static void callCustomRPUpdate() {
        if (customRPMode.equalsIgnoreCase("addon")) {
            RichPresence.Builder builder = new RichPresence.Builder();
            client.sendRichPresence(builder
                    .setSmallImage("compass")
                    .setLargeImage("hyperium", "Hyperium Client")
                    .setState("Playing a game")
                    .setDetails("CustomRP Addon")
                    .setStartTimestamp(OffsetDateTime.now())
                    .build());
        } else if (customRPMode.equalsIgnoreCase("vewels")) {
            RichPresence.Builder builder = new RichPresence.Builder();
            String eIfiedUsername = Minecraft.getMinecraft().getSession().getUsername();
            eIfiedUsername = eIfiedUsername.replace('a', 'e');
            eIfiedUsername = eIfiedUsername.replace('i', 'e');
            eIfiedUsername = eIfiedUsername.replace('o', 'e');
            eIfiedUsername = eIfiedUsername.replace('u', 'e');
            eIfiedUsername = eIfiedUsername.replace('A', 'e');
            eIfiedUsername = eIfiedUsername.replace('I', 'e');
            eIfiedUsername = eIfiedUsername.replace('O', 'e');
            eIfiedUsername = eIfiedUsername.replace('U', 'e');
            client.sendRichPresence(builder
                    .setSmallImage("compass")
                    .setLargeImage("hyperium", "Hyperium Client")
                    .setState("eGN: ".concat(eIfiedUsername))
                    .setDetails("CestemRP edden")
                    .setStartTimestamp(OffsetDateTime.now())
                    .build());
        } else if (customRPMode.equalsIgnoreCase("eee")) {
            RichPresence.Builder builder = new RichPresence.Builder();
            String allEUsername = "";
            for (int x = 0; x < Minecraft.getMinecraft().getSession().getUsername().length();) {
                allEUsername = allEUsername.concat("e");
                x++;
            }
            client.sendRichPresence(builder
                    .setSmallImage("compass")
                    .setLargeImage("hyperium", "Hyperium Client")
                    .setState("eee: ".concat(allEUsername))
                    .setDetails("eeeeeeee eeeee")
                    .setStartTimestamp(OffsetDateTime.now())
                    .build());
        } else if (customRPMode.equalsIgnoreCase("sellout")) {
            RichPresence.Builder builder = new RichPresence.Builder();
            client.sendRichPresence(builder
                    .setSmallImage("compass")
                    .setLargeImage("hyperium", "Hyperium Client")
                    .setState("Subscribe to ".concat(Minecraft.getMinecraft().thePlayer.getName()))
                    .setDetails("CustomRP Addon")
                    .setStartTimestamp(OffsetDateTime.now())
                    .build());
        } else {
            customRPMode = "addon";
            callCustomRPUpdate();
        }
    }

    CustomRPUpdater(IPCClient client) {
        this.client = client;
        if (!GeneralSetting.discordRPEnabled) {
            return;
        }

        callCustomRPUpdate();
    }
}
