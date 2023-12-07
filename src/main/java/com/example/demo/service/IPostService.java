package com.example.demo.service;

import com.example.demo.dto.PostDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IPostService {
    List<PostDto> getAll();
}
