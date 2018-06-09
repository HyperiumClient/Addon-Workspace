package me.shardcoder.addon;

import cc.hyperium.Hyperium;
import cc.hyperium.event.*;
import cc.hyperium.internal.addons.IAddon;
import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.DiscordBuild;
import com.jagrosh.discordipc.exceptions.NoDiscordClientException;

import static com.jagrosh.discordipc.entities.pipe.PipeStatus.CONNECTED;

public class CustomRP implements IAddon {
    private IPCClient client;

    @Override
    public void onLoad() {
        System.out.println("[CustomRP] Addon loaded");
        EventBus.INSTANCE.register(this);
    }

    @InvokeEvent
    public void init(InitializationEvent event) {
        Hyperium.INSTANCE.getHandlers().getHyperiumCommandHandler().registerCommand(new CustomRPCommand());
    }

    @InvokeEvent(priority = Priority.HIGH)
    public void initHighPriority(InitializationEvent event) {
        this.client = new IPCClient(412963310867054602L);
        this.client.setListener(new IPCListener() {
            @Override
            public void onReady(IPCClient client) {
                EventBus.INSTANCE.register(new CustomRPUpdater(client));
            }
        });
        try {
            client.connect(DiscordBuild.ANY);
        } catch (NoDiscordClientException e) {
            Hyperium.LOGGER.warn("no discord clients found");
        }
    }

    @Override
    public void onClose() {
        System.out.println("[CustomRP] Addon closed");

        try {
            if (this.client != null && this.client.getStatus() == CONNECTED) {
                this.client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void sendDebugInfo() {
    }
}
