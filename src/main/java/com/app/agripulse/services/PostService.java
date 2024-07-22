package com.app.agripulse.services;

import com.app.agripulse.dtos.PostDto;

import java.util.List;

public interface  PostService {
    List<PostDto> getAllPosts();
    PostDto getPostById(Long id);
    PostDto createPost(PostDto postDto);
    PostDto updatePost(Long id, PostDto postDto);
    void deletePost(Long id);
}
