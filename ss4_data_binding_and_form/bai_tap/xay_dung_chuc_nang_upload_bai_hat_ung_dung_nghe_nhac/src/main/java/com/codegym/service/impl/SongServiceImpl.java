package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    private List<Song> songList = new ArrayList<>();

    @Override
    public List<Song> findAll() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }
}
