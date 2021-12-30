package com.likecho.near.dao;

import com.likecho.near.model.Album;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AlbumMapper {
    @Select("SELECT * FROM album")
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
    })
    List<Album> getAllAlbum();

    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
    })
    @Select("SELECT * FROM album WHERE id = 1")
    Album getAlbum();
}