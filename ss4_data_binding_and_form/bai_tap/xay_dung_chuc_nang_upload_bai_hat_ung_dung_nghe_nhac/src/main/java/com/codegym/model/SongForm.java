package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private String name;
    private String artist;
    private String kindOfMusic;
    private MultipartFile songPath;

    public SongForm() {
    }

    public SongForm(String name, String artist, String kindOfMusic, MultipartFile songPath) {
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

    public MultipartFile getSongPath() {
        return songPath;
    }

    public void setSongPath(MultipartFile songPath) {
        this.songPath = songPath;
    }
}
