package com.app.agripulse.services;

import com.app.agripulse.dtos.CommentDto;
import com.app.agripulse.models.Comment;

import java.util.List;

public interface  CommentService {

    List<CommentDto> getComments();

    CommentDto createComment(CommentDto commentDto);

    CommentDto getCommentById(Long id);

    CommentDto updateComment(Long id, CommentDto commentDto);

    void deleteComment(Long id);

}
