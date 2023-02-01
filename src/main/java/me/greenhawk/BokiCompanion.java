package me.greenhawk;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class BokiCompanion {
    public BokiCompanion() {
        DiscordRPC lib = DiscordRPC.INSTANCE;
        String applicationId = "1067512435101159484";
        String steamId = "";
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> System.out.println("Bokibot launched");
        lib.Discord_Initialize(applicationId, handlers, true, steamId);
        DiscordRichPresence presence = new DiscordRichPresence();
        presence.state = "State";
        presence.details = "Details";
        presence.largeImageKey = "";
        presence.largeImageText = "";
        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        lib.Discord_UpdatePresence(presence);
        // in a worker thread
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        },"RPC-Callback-Handler").start();
    }

    public static void main(String[] args) {
        new BokiCompanion();
    }
}