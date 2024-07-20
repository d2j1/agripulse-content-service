package com.app.agripulse.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Post extends BaseModel{

    private String title;
    private String content;
    private Long userId;
    private String url;
    private Long viewersCount;
    @OneToMany
    private List<Like> likes;
    @OneToMany
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostType postType;

}
