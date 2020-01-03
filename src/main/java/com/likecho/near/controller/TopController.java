package com.likecho.near.controller;

import com.likecho.near.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TopController {
    private Logger logger = LoggerFactory.getLogger(TopController.class);

    @RequestMapping(value = "/api/top/playlist")
    public Map getPlayList() {
        Map<String, User> data = new HashMap<>();

        User user = new User();
        user.setId(1);
        user.setUsernmae("蒋龙豪");
        data.put("playlists", user);
        return data;
    }
}
