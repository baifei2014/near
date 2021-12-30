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
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/api/user/{userId}")
    public Map getUser(@PathVariable int userId) {
        Map<String, User> data = new HashMap<>();

        User user = new User();
        user.setId(1);
        user.setUsernmae("蒋龙豪");
        data.put("account", user);
        return data;
    }
}
