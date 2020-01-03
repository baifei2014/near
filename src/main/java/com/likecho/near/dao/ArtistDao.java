package com.likecho.near.dao;

import com.likecho.near.model.Artist;

import java.util.List;

public interface ArtistDao {
    List<Artist> getAllArtist();
    Artist getArtist();
}
