package com.modsen.pizzeria.redis;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.modsen.pizzeria.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate template;

    public static void saveAll(List<Token> validUserTokens) {
    }

    public static List<Token> findAllValidTokenByUser(Long id) {
        return new ArrayList<>();
    }

    public void saveToken(Long user_id, Token token) throws JsonProcessingException {

        template.opsForValue().set(String.valueOf(user_id), toJSON(token));
    }
    public void saveToken(Token token) {
        template.opsForValue().set(String.valueOf(token.getUser_id()), token);
    }

    public String getToken(Long user_id){
       return String.valueOf(template.opsForValue().get(String.valueOf(user_id)));
    }

    public Optional<Token> findByToken(String jwtToken) {
        Token token = new Token();
        return Optional.of(token);
    }

    public String toJSON(Token token) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(token);
    }
}
