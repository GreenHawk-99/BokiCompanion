package me.greenhawk.discord;

import club.minnced.discord.rpc.DiscordRichPresence;
import me.greenhawk.browser.BrowserData;

public class Data {
    private String client = "No client";
    private String song = "Waiting for music...";
    private String artist = "No Artist";
    private String timestamp = "0:00";

    public void start() {
        System.out.println("Starting Bokibot");
        update(song,artist);

        BrowserData data = new BrowserData();
        if (data.getSong() == null || data.getTimestamp() == "0:00") {
            System.err.println("No data");
            return;
        } else if (song == data.getSong()) {
            System.err.println("Error code: Song");
            return;
        }
        timestamp = data.getTimestamp().replace(" ","");
    }

    public void update(String song, String artist) {
        DiscordRichPresence presence = new DiscordRichPresence();
        presence.state = artist;
        presence.details = song;
    }
}
