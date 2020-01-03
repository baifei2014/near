package com.likecho.near.controller;

import com.likecho.near.model.Poi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NearController {
    private Logger logger = LoggerFactory.getLogger(NearController.class);

    @RequestMapping(value = "/api/near/get/{positionId}")
    public Map getPosition(@PathVariable int positionId) {
        Map<String, Poi> data = new HashMap<>();

        Poi position = new Poi();
        data.put("北京", position);
        return data;
    }

}