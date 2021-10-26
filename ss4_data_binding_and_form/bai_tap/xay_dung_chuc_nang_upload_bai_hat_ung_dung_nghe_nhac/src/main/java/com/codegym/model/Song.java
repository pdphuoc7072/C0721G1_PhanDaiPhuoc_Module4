package com.codegym.model;

public class Song {
    private String name;
    private String artist;
    private String kindOfMusic;
    private String songPath;

    public Song() {
    }

    public Song(String name, String artist, String kindOfMusic, String songPath) {
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.songPath = songPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
}
