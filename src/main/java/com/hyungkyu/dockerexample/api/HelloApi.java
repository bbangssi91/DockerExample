package com.hyungkyu.dockerexample.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping(value = "/")
    public String hello() {
        redisTemplate.opsForValue().set("hello", "Docker Container");
        return "Hello, Docker Container!";
    }
}
