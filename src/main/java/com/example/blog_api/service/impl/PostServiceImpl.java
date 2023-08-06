package com.example.blog_api.service.impl;

import com.example.blog_api.dto.PostDto;
import com.example.blog_api.entity.Post;
import com.example.blog_api.exception.ResourceNotFoundException;
import com.example.blog_api.repository.PostRepository;
import com.example.blog_api.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    private ModelMapper mapper;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        return mapToDto(post);
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post newPost = mapToEntity(postDto);
        return mapToDto(postRepository.save(newPost));
    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }

    @Override
    public List<PostDto> getPostByTag(Long tagId) {
        List<Post> posts = postRepository.findByTagId(tagId);
        List<PostDto> postDtos = posts.stream().map(user -> mapToDto(user))
                .collect(Collectors.toList());
        return postDtos;
    }

    private Post mapToEntity(PostDto postDto) {
        return mapper.map(postDto, Post.class);
    }

    private PostDto mapToDto(Post post) {
        return mapper.map(post, PostDto.class);
    }
}
