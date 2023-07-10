package com.example.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        String keys = "keys_";
        redisTemplate.delete(redisTemplate.keys(keys + "*"));
        Object msg = redisTemplate.opsForValue().get(keys + 1);
        if (msg == null) {
            msg = "没有了";
        }
        System.out.println("---------》移除后内容为：" + msg);
    }

}
