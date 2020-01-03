package com.likecho.near.dao;

import com.likecho.near.model.Song;

import java.util.List;

public interface SongDao {
    List<Song> getAllSong();
    Song getSong();
}
