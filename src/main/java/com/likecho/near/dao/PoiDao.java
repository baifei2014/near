package com.likecho.near.dao;

import com.likecho.near.model.Poi;

import java.util.List;

public interface PoiDao {
    List<Poi> getAllPoi();
    Poi getPoi();
}
