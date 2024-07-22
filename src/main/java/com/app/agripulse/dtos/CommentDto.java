package com.app.agripulse.dtos;

import com.app.agripulse.models.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String comment;
    private Long userId;

    public static CommentDto toDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setComment(comment.getComment());
        dto.setUserId(comment.getUserId());
        return dto;
    }

    public static Comment toComment(CommentDto dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setComment(dto.getComment());
        comment.setUserId(dto.getUserId());
        return comment;
    }
}
