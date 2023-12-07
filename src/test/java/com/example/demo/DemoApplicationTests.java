package com.example.demo;

import com.example.demo.model.PostEntity;
import com.example.demo.repository.PostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PostRepository postRepository;

    @Test
    void contextLoads() throws JsonProcessingException {
        String responseBody = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, null, String.class).getBody();
        var postList = objectMapper.readValue(responseBody, new TypeReference<List<PostEntity>>() {});
        Assertions.assertTrue(postList.stream().toList().size()>0);
    }

}
