package com.example.demo.service.impl;

import com.example.demo.dto.PostDto;
import com.example.demo.model.PostEntity;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.IPostService;
import com.example.demo.service.RedisService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    private final ModelMapper modelMapper;

    private final PostRepository postRepository;

    private final RedisService redisService;


    public PostServiceImpl(ModelMapper modelMapper, PostRepository postRepository, RedisService redisService) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
        this.redisService = redisService;
    }

    @Cacheable(value = "allProduct")
    @Override
    public List<PostDto> getAll() {
        List<PostEntity> listPostEntity = (List<PostEntity>) postRepository.findAll();
        List<PostDto> response  = listPostEntity.stream().map(postEntity -> modelMapper.map(postEntity, PostDto.class)).toList();
        return response;
    }
}
