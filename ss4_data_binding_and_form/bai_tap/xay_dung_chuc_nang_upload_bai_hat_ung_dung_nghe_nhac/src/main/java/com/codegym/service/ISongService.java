package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll ();
    void save (Song song);
}
