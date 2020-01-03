package com.likecho.near.controller;

import com.likecho.near.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BannerController {
    private Logger logger = LoggerFactory.getLogger(BannerController.class);

    @RequestMapping(value = "/api/banner")
    public Map getBanner() {
        Map<String, User> data = new HashMap<>();

        User user = new User();
        user.setId(1);
        user.setUsernmae("蒋龙豪");
        data.put("banners", user);
        return data;
    }
}
