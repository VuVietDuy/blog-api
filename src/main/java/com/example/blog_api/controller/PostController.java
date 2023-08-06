package com.example.blog_api.controller;

import com.example.blog_api.dto.PostDto;
import com.example.blog_api.entity.Post;
import com.example.blog_api.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("postId") Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @GetMapping()
    public List<Post> getAllPost() {
        return null;
    }

    @PostMapping()
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.createPost(postDto));
    }

    @GetMapping("/tag/{tagId}")
    public ResponseEntity<List<PostDto>> getPostByTag(@PathVariable("tagId") Long tagId) {
        return ResponseEntity.ok(postService.getPostByTag(tagId));
    }
}
