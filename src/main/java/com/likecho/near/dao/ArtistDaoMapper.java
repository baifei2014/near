package com.likecho.near.dao;

import com.likecho.near.model.Artist;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArtistDaoMapper {
    @Select("SELECT * FROM artist")
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
    })
    List<Artist> getAllArtist();

    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
    })
    @Select("SELECT * FROM artist WHERE id = 1")
    Artist getArtist();
}