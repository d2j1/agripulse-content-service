package com.app.agripulse.controller;

import com.app.agripulse.dtos.PostDto;
import com.app.agripulse.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getPosts() {
        List<PostDto> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        PostDto post = postService.getPostById(id);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto post) {
        PostDto postDto = postService.createPost(post);
        return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }
}
