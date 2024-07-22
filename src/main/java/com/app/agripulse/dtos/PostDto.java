package com.app.agripulse.dtos;

import com.app.agripulse.models.Comment;
import com.app.agripulse.models.Post;
import com.app.agripulse.models.PostType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostDto {

    private String title;
    private String content;
    private Long userId;
    private String url;
    private Long viewersCount;
    private Long likes;
    private List<Comment> comments;
    private PostType postType;

    public static PostDto fromPost(Post post) {
        PostDto dto = new PostDto();
        dto.title = post.getTitle();
        dto.content = post.getContent();
        dto.userId = post.getUserId();
        dto.url = post.getUrl();
        dto.viewersCount = post.getViewersCount();
        dto.likes = post.getLikes();
        dto.comments = post.getComments();
        dto.postType = post.getPostType();
        return dto;
    }

    public static Post toPost(PostDto dto) {
        Post post = new Post();
        post.setTitle(dto.title);
        post.setContent(dto.content);
        post.setUserId(dto.userId);
        post.setUrl(dto.url);
        post.setViewersCount(dto.viewersCount);
        post.setLikes(dto.likes);
        post.setComments(dto.comments);
        post.setPostType(dto.postType);
        return post;
    }

}
