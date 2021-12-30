package com.likecho.near.dao;

import com.likecho.near.model.Song;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SongMapper {
    @Select("SELECT * FROM song")
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
    })
    List<Song> getAllSong();

    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
    })
    @Select("SELECT * FROM song WHERE id = 1")
    Song getSong();
}