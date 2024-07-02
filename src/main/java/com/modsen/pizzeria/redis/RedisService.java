package com.modsen.pizzeria.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate template;

    public void saveToken(Long user_id, String token) {
        template.opsForValue().set(String.valueOf(user_id), token);
    }

    public String getToken(Long user_id){
       return String.valueOf(template.opsForValue().get(String.valueOf(user_id)));
    }
}
