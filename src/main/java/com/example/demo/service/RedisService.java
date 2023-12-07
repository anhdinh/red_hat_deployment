package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedisService {
    private final RedisTemplate<String, String> redisTemplate;

    private final ObjectMapper objectMapper;

    public RedisService(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public void setKey(String key, Object object) throws JsonProcessingException {
        redisTemplate.opsForValue().set(key, objectMapper.writeValueAsString(object));
    }

    public <T> Optional<T> getKey(String key, TypeReference<T> type) throws JsonProcessingException {
        String value = redisTemplate.opsForValue().get(key);
        if(value!=null){
            return Optional.of(objectMapper.readValue(value, type));
        }
        return Optional.empty();

    }
}
