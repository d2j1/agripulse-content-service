package com.app.agripulse.serviceImpl;

import com.app.agripulse.dtos.PostDto;
import com.app.agripulse.exceptions.NoPostFound;
import com.app.agripulse.exceptions.SomethingWentWrongException;
import com.app.agripulse.models.Post;
import com.app.agripulse.repository.PostRepository;
import com.app.agripulse.services.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        if(posts.isEmpty()){
            throw new NoPostFound("No posts found", null);
        }

        List<PostDto> postDtos = new ArrayList<>();


        for( Post post : posts){
            postDtos.add(PostDto.fromPost(post));
        }

        return postDtos;
    }

    @Override
    public PostDto getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            return PostDto.fromPost(post.get());
        }else{
            throw new NoPostFound("No post found", id);
        }

    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = PostDto.toPost(postDto);
        try {
            post = postRepository.save(post);
            return PostDto.fromPost(post);
        }catch (Exception e){
            throw new SomethingWentWrongException("Something went wrong while saving the post. Please try again");
        }

    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
        return null;
    }

    @Override
    public void deletePost(Long id) {

    }
}
