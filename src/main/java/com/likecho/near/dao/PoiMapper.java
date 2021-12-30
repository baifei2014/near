package com.likecho.near.dao;

import com.likecho.near.model.Poi;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PoiMapper {
    @Select("SELECT * FROM poi")
    @Results(value = {
            @Result(column = "longitude", property = "longitude"),
            @Result(column = "latitude", property = "latitude"),
    })
    List<Poi> getAllPoi();

    @Results(value = {
            @Result(column = "longitude", property = "longitude"),
            @Result(column = "latitude", property = "latitude"),
    })
    @Select("SELECT * FROM poi WHERE id = 1")
    Poi getPoi();
}