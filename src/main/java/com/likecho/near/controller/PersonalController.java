package com.likecho.near.controller;

import com.likecho.near.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PersonalController {
    private Logger logger = LoggerFactory.getLogger(PersonalController.class);

    @RequestMapping(value = "/api/personalized")
    public Map getPersonalised() {
        Map<String, User> data = new HashMap<>();

        User user = new User();
        user.setId(1);
        user.setUsernmae("蒋龙豪");
        data.put("all", user);
        return data;
    }

    @RequestMapping(value = "/api/personalized/newsong")
    public Map getNewSong() {
        Map<String, User> data = new HashMap<>();

        User user = new User();
        user.setId(1);
        user.setUsernmae("蒋龙豪");
        data.put("all", user);
        return data;
    }

    @RequestMapping(value = "/api/personalized/mv")
    public Map getMv() {
        Map<String, User> data = new HashMap<>();

        User user = new User();
        user.setId(1);
        user.setUsernmae("蒋龙豪");
        data.put("all", user);
        return data;
    }

    @RequestMapping(value = "/api/personalized/djprogram")
    public Map getDjprogram() {
        Map<String, User> data = new HashMap<>();

        User user = new User();
        user.setId(1);
        user.setUsernmae("蒋龙豪");
        data.put("all", user);
        return data;
    }
}
