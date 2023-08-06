package com.example.blog_api.service;

import com.example.blog_api.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto getPostById(Long postId);

    List<PostDto> getAllPosts();

    List<PostDto> getPostByTag(Long tagId);

    PostDto createPost(PostDto postDto);
}
