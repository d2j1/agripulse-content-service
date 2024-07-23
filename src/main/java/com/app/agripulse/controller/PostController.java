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
    public ResponseEntity<List<PostDto>> getPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<PostDto> posts = postService.getAllPosts(page, size);
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

    @PutMapping("/update/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostDto post) {
        PostDto postDto = postService.updatePost(id, post);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
