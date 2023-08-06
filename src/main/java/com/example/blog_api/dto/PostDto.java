package com.example.blog_api.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    
    private Long id;
    
    private String title;

    private String body;
    
    private String titleURL;
    
    private List<FileDto> images;

    private Long tagId;
}
