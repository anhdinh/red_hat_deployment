package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String title;
    private String body;
    private Long userId;
}
