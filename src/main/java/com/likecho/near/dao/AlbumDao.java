package com.likecho.near.dao;

import com.likecho.near.model.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> getAllAlbum();
    Album getAlbum();
}
