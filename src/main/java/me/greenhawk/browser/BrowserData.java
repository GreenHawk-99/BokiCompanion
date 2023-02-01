package me.greenhawk.browser;

public class BrowserData {

    private String client;
    private String song;
    private String artist;
    private String timestamp;

    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }

    public String getSong() {
        return song;
    }
    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}