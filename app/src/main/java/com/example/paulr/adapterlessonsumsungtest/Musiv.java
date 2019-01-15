package com.example.paulr.adapterlessonsumsungtest;

public class Musiv {
    private String artist;
    private String music;
    private int albunImgeId;

    Musiv(String atrist, String music, int albunImgeId){
        this.artist = atrist;
        this.music = music;
        this.albunImgeId = albunImgeId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public int getAlbunImgeId() {
        return albunImgeId;
    }

    public void setAlbunImgeId(int albunImgeId) {
        this.albunImgeId = albunImgeId;
    }
}
