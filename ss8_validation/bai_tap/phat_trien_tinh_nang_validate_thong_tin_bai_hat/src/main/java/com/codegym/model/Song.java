package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String songName;

    private String artist;

    private String typeOfMusic;

    public Song() {
    }

    public Song(Long id, String songName, String artist, String typeOfMusic) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.typeOfMusic = typeOfMusic;
    }

    public Song(String songName, String artist, String typeOfMusic) {
        this.songName = songName;
        this.artist = artist;
        this.typeOfMusic = typeOfMusic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        String[] characterError = {"@", ";", ",", ".", "=", "-", "+"};
        String songName = song.getSongName();
        String artist = song.getArtist();
        String typeOfMusic = song.getTypeOfMusic();
        ValidationUtils.rejectIfEmpty(errors, "songName", "songName.empty");
        if (songName.length() > 800) {
            errors.rejectValue("songName", "songName.length");
        }
        for (int i = 0; i < characterError.length; i++) {
            if (songName.contains(characterError[i])) {
                errors.rejectValue("songName", "songName.contains");
            }
        }
        ValidationUtils.rejectIfEmpty(errors, "artist", "artist.empty");
        if (artist.length() > 300) {
            errors.rejectValue("artist", "artist.length");
        }
        for (int i = 0; i < characterError.length; i++) {
            if (artist.contains(characterError[i])) {
                errors.rejectValue("artist", "artist.contains");
            }
        }
        ValidationUtils.rejectIfEmpty(errors, "typeOfMusic", "typeOfMusic.empty");
        if (typeOfMusic.length() > 1000) {
            errors.rejectValue("typeOfMusic", "typeOfMusic.length");
        }
        for (int i = 0; i < characterError.length; i++) {
            if (i != 2) {
                if (typeOfMusic.contains(characterError[i])) {
                    errors.rejectValue("typeOfMusic", "typeOfMusic.contains");
                }
            }
        }
    }
}
