package com.likecho.near.controller;

import com.likecho.near.model.User;
import com.likecho.near.service.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RecommendController {
    private Logger logger = LoggerFactory.getLogger(RecommendController.class);
    @Autowired
    SongService songService;
    @RequestMapping(value = "/api/recommend/songs")
    public Map songs() {
        Map<String, List> data = new HashMap<>();
        List list = songService.getAllSong();
        data.put("recommend", list);
        return data;
    }
}
