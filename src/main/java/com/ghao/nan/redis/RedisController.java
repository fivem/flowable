package com.ghao.nan.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/set/{key}/{value}",method = RequestMethod.GET )
    public String setRedisValue(@PathVariable String key,@PathVariable Object value){
        redisService.set(key,value);
        return "success";
    }

    @RequestMapping(value = "/get/{key}",method = RequestMethod.GET)
    public String getReids(@PathVariable String key){
        return (String)redisService.get(key);
    }
}
