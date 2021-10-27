package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private Long id;
    private String name;
    private String artist;
    private String typeOfMusic;
    private MultipartFile filePath;

    public MusicForm() {
    }

    public MusicForm(String name, String artist, String typeOfMusic, MultipartFile filePath) {
        this.name = name;
        this.artist = artist;
        this.typeOfMusic = typeOfMusic;
        this.filePath = filePath;
    }

    public MusicForm(Long id, String name, String artist, String typeOfMusic, MultipartFile filePath) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.typeOfMusic = typeOfMusic;
        this.filePath = filePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public MultipartFile getFilePath() {
        return filePath;
    }

    public void setFilePath(MultipartFile filePath) {
        this.filePath = filePath;
    }
}
