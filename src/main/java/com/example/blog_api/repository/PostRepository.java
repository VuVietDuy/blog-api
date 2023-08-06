package com.example.blog_api.repository;

import com.example.blog_api.dto.PostDto;
import com.example.blog_api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post newPost);
    List<Post> findByTagId(Long tagId);
}
